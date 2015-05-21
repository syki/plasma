Prunning : FilterPattern { // Emits the running result of applying the given operator.

	var < initial, < operator;

*	new { |... arguments|
		^ this.dispatchOnArity (thisMethod, * arguments);
	}

*	new1 { |pattern|
		^ Prunner (pattern);
	}

*	new2 { |pattern, operator|
		^ super.newCopyArgs (pattern, nil, operator);
	}

*	new3 { |pattern, initial, operator|
		^ super.newCopyArgs (pattern, initial, operator);
	}

	storeArgs {
		^ [pattern, initial, operator];
	}
	
	embedInStream { |event|
		var stream = pattern.asStream;
		var output = initial ? stream.next (event);
		loop {
			output.yield;
			output = this.operator.applyTo (output, stream.next (event));
		}
	}

}
