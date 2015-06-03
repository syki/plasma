Chan : AbstractHandedFunction {
	
	var <> subscribers, <> value;

*	new { |initialValue|
		^ super.new.subscribers_ (List.new).value_ (initialValue);
	}

	initializeValue {
		value = this.initialValue;
	}

	initialValue {
		^ nil;
	}

	asStream {
		^ Routine ({ |inEvent| this.embedInStream (inEvent) });
	}

	embedInStream { |inEvent|
		loop { value.yield };
	}

	put { |... arguments|
		subscribers.do { |subscriber| subscriber.value (* arguments) };
		value = if (arguments.isSingleton) { arguments.singleton } { nil };
	}

	do { |callback|
		subscribers = subscribers.add (callback);
	}

	gather { |predicate|
		^ ChanGather (this, predicate);
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
