ChanBinary : ChanFunction {
	
	var hand;
	var leftChan, leftValue;
	var rightChan, rightValue;

	arguments_ { |arguments|
		# leftChan, rightChan, hand = arguments;
	}

	load {
		this.loadLeft;
		this.loadRight;
	}

	loadLeft {
		leftChan.do (this.leftFunc);
	}

	leftFunc {
		^ if (\right === hand, this.leftHold, this.leftFlush);
	}

	leftHold {
		^ `{ |value| leftValue = value };
	}

	leftFlush {
		^ `{ |value| leftValue = value; unless (rightValue.isNil) { this.flush } };
	}

	loadRight {
		rightChan.do (this.rightFunc);
	}

	rightFunc {
		^ if (\left === hand, this.rightHold, this.rightFlush);
	}

	rightHold {
		^ `{ |value| rightValue = value };
	}

	rightFlush {
		^ `{ |value| rightValue = value; unless (leftValue.isNil) { this.flush } };
	}

	flush {
		this.put (leftValue, rightValue);
	}

}
