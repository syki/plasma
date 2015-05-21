Pmover : FilterPattern {

	var < windowSize;

*	new { |... arguments|
		^ this.dispatchOnArity (thisMethod, * arguments);
	}

*	new2 { |pattern, windowSize|
		^ super.newCopyArgs (pattern, windowSize);
	}

	storeArgs {
		^ [pattern, windowSize];
	}
	
	embedInStream { |event|
		var stream = pattern.asStream;
		var n = windowSize;
		var m = windowSize - 1;
		var windowedValues = Array.fill (n) { stream.next (event); }.reverse;
		loop {
			windowedValues.copy.yield;

			m.reverseDo { |i| windowedValues[i + 1] = windowedValues[i]; };
			windowedValues[0] = stream.next (event);
		}
	}
	
	difference {
		^ this.collect { |xs| xs.reduce (_ - _); }
	}

	ratio {
		^ this.collect { |xs| xs.reduce (_ / _); }
	}

	average {
		^ this.mean;
	}

	mean {
		^ this.collect (_.mean);
	}

	median {
		^ this.collect (_.median);
	}

}
