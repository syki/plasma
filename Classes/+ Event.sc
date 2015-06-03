+ Event {
	
	with { |... arguments|
		^ this.dispatchOnArity (thisMethod, * arguments);
	}

	with1 { |event|
		^ Event (8, event, this);
	}

	withN { |... pairs|
		^ with1 (Event.newFrom (pairs));
	}

	populateFromSynthDesc { |synthLib|
		this.use {
			~synthLib  ?? { ~synthLib  = synthLib ? SynthDescLib.global };
			~synthDesc ?? { ~synthDesc = ~synthLib.match (~instrument) };
			~hasGate   ?? { ~hasGate = if (~synthDesc.notNil) { ~synthDesc.hasGate } { false } };
			~msgFunc   ?? { ~msgFunc = if (~synthDesc.notNil) { ~synthDesc.msgFunc } { ~defaultMsgFunc } };
		}
	}

}
