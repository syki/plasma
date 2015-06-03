ChanBinaryOp : ChanBinary {
	
	var operator, adverb;

	arguments_ { |arguments|
		# operator, leftChan, rightChan, adverb, hand = arguments;
		rightValue = rightChan.value;
		leftValue = leftChan.value;
	}

	initialValue {
		if (leftValue.notNil and: { rightValue.notNil }) { ^ this.evaluate };
	}

	evaluate {
		^ leftValue.perform (operator, rightValue, adverb);
	}

	flush {
		this.put (this.evaluate);
	}

}
