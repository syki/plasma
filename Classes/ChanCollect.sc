ChanCollect : Chan {

	var source, function;

	arguments_ { |arguments|
		# source, function = arguments;
	}

	prepare {
		source.do { |inValue|
			if (inValue.isNil) { ^ this.finish };
			this.put (function.value (inValue));
		};
	}	

}
