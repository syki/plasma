+ Object {
	
	dispatchOnArity { |method ... arguments|
		var selector = method.name;
		var selectorM = [selector, arguments.size].join.asSymbol;
		var selectorN = [selector, "N"].join.asSymbol;
		selector = if (this.respondsTo (selectorM)) { selectorM } { selectorN };
		^ this.perform (selector, * arguments);
	}

	postfln { |format ... arguments|
		(format ++ "\n").postf (this, * arguments);
	}

}
