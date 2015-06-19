ChanUnaryOp : Chan { 

	var operator, receiver;

	arguments_ { |arguments|
		# operator, receiver = arguments;
	}

	initialValue {
		^ receiver.value.perform (operator);
	}

	prepare {
		receiver.do { |inValue|
			if (inValue.isNil) { ^ this.finish };
			this.put (inValue.perform (operator));
		};
	}
	
}
