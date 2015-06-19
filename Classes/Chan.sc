Chan : AbstractHandedFunction {
	
	var < subscribers, < value;

*	new { |... arguments|
		^ super.new.preinitialize.arguments_ (arguments).postinitialize;
	}

	preinitialize {
		subscribers = List.new;
	}

	arguments_ { |arguments|
		value = arguments.first;
	}

	postinitialize {
		this.initializeValue;
		this.prepare;
	}

	initializeValue {
		this.initialValue !? { value = this.initialValue };
	}

	initialValue {
		^ nil;
	}

	prepare {
	}

	asStream {
		^ Routine ({ |inEvent| this.embedInStream (inEvent) });
	}

	embedInStream { |inEvent|
		while { value.notNil } { value.yield };
		^ inEvent;
	}

	put { |argument|
		subscribers.do { |subscriber| subscriber.value (argument) };
		value = argument;
	}

	do { |callback|
		subscribers = subscribers.add (callback);
	}

	finish {
		this.put (nil);
		this.subscribers = nil;
	}

	collect { |function|
		^ ChanCollect (this, function);
	}

	gather { |predicate|
		^ ChanGather (this, predicate);
	}

	gesture {
		^ this.gather { |argument| argument.notNil and: argument.nonZero };
	}

	++ { |that|
		^ ChanBinary (this, that);
	}

	>++ { |that|
		^ ChanBinary (this, that, \left);
	}

	++< { |that|
		^ ChanBinary (this, that, \right);
	}

*	classUnaryOp {
		^ ChanUnaryOp;
	}

*	classBinaryOp {
		^ ChanBinaryOp;
	}

*	classNAryOp {
		^ ChanNAryOp;
	}

}
