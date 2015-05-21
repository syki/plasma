Precurring : Pattern { // Recursively defined sequence.
	
	var < initialValues, < nextFunction;

*	new { |initialValues, nextFunction|
		^ super.newCopyArgs (initialValues.asArray, nextFunction);
	}

	storeArgs {
		^ [initialValues, nextFunction];
	}	

	embedInStream { |event|
		var n = initialValues.size;
		var m = n - 1;
		var previousValues = initialValues.copy;
		var nextValue;

		n.do { |i|
			initialValues[i].yield;
		};
		
		loop {
			nextValue = nextFunction.applyTo (* previousValues);
			nextValue.yield;

			m.do { |i| previousValues[i] = previousValues[i + 1]; };
			previousValues[m] = nextValue;
		};
	}

}
