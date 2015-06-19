Instrument : EventRedirect {
	
	var <> template;
	var <> bus, <> group;
	var armed = true, dirty = false;

*	new { |template|
		^ super.new.template_ (template);
	}

	prefresh {

	}

	refresh {
		if (armed && dirty) { dirty = false; this.prefresh };
	}

	transmogrify { |function|
		var result;
		this.armed = false;
		result = function.value;
		this.armed = true;
		this.refresh;
		^ result;
	}

	use { |function|
		^ this.transmogrify { super.use (function) };
	}

	put { |key, value|
		^ this.transmogrify { dirty = true; super.put (key, value) };
	}

	play {
		// link to main out
	}

	asSynthDef {
		^ this.use { template.asSynthDef };
	}

	buildForProxy { |... arguments|
		^ this.use { ^ super.buildForProxy (* arguments) };
	}

	prepareForProxySynthDef {
		^ template;
	}

	defaultArgs {
		^ template.def.prototypeFrame;
	}

	argNames {
		^ template.def.argNames;
	}

}
