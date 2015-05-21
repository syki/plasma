Pmoving : FilterPattern { // Windowed map.

	var < windowSize, < nextFunction;

*	new { |... arguments|
		^ this.dispatchOnArity (thisMethod, * arguments);
	}

*	new2 { |pattern, windowSize|
		^ Pmover (pattern, windowSize);
	}

*	new3 { |pattern, windowSize, nextFunction|
		^ super.newCopyArgs (pattern, windowSize, nextFunction);
	}

	storeArgs {
		^ [pattern, windowSize, nextFunction];
	}
	
	embedInStream { |event|
		var stream = pattern.asStream;
		var n = windowSize;
		var m = windowSize - 1;
		var windowedValues = Array.fill (n) { stream.next (event); }.reverse;
		var nextValue;
		loop {
			nextValue = this.nextFunction.applyTo (* windowedValues);
			nextValue.yield;

			m.reverseDo { |i| windowedValues[i + 1] = windowedValues[i]; };
			windowedValues[0] = stream.next (event);
		}
	}

}
