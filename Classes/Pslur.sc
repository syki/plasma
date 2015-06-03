Pslur : FilterPattern {
	
	classvar < immutableKeys = #[ instrument, variant, id, group, in, out, bus, bufnum, server ];

	var <> keys;

*	new { |pattern ... keys|
		keys = if (keys.isEmpty) { nil } { keys union: immutableKeys };
		^ super.new.pattern_ (pattern).keys_ (keys);
	}

	storeArgs {
		^ [pattern] ++ keys;
	}

	embedInStream { |inEvent|
		^ PslurStream (this).embedInStream (inEvent);
	}

}
