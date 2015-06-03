ChanUnaryOp : ChanFunction { 

	var operator, receiver;

	arguments_ { |arguments|
		# operator, receiver = arguments;
	}

	initialValue {
		^ receiver.value.perform (operator);
	}

	load {
		receiver.do { |inValue|
			this.put (inValue.perform (operator));
		};
	}
	
}
