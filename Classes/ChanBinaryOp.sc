ChanBinaryOp : Chan {
	
	var operator, adverb, hand;
	var leftChan, leftValue;
	var rightChan, rightValue;

	arguments_ { |arguments|
		# operator, leftChan, rightChan, adverb, hand = arguments;
		leftValue = leftChan.value; rightValue = rightChan.value;
	}

	initialValue {
		if (leftValue.notNil and: { rightValue.notNil }) { ^ this.evaluate };
	}

	prepare {
		if (leftChan.isKindOf (Chan)) { leftChan.do (this.leftHandle (_)) };
		if (rightChan.isKindOf (Chan)) { rightChan.do (this.rightHandle (_)) };
	}

	leftHandle { |inValue|
		if (inValue.isNil) { ^ this.finish };
		this.perform (if (\right === hand) { \leftHold } { \leftFlush }, inValue);
	}

	leftHold { |inValue|
		leftValue = inValue;
	}

	leftFlush { |inValue|
		leftValue = inValue;
		unless (rightValue.isNil) { this.flush };
	}

	rightHandle { |inValue|
		if (inValue.isNil) { ^ this.finish };
		this.perform (if (\left === hand) { \rightHold } { \rightFlush }, inValue);
	}

	rightHold { |inValue|
		rightValue = inValue;
	}

	rightFlush { |inValue|
		rightValue = inValue;
		unless (leftValue.isNil) { this.flush };
	}

	evaluate {
		^ leftValue.perform (operator, rightValue, adverb);
	}

	flush {
		this.put (this.evaluate);
	}

}
