+ Object {
	
	dispatchOnArity { |method ... arguments|
		var selector = method.name, aritySelector;
		var arity = arguments.size;
		^ case
		
		{ this.respondsTo (aritySelector = [selector, arity].join.asSymbol) }
		{ this.perform (aritySelector, * arguments) }

		{ this.respondsTo (aritySelector = [selector, "N"].join.asSymbol) }
		{ this.perform (aritySelector, * arguments) }

		{ Error ("Unable to dispatchOnArity for " ++ selector ++ " and " ++ arguments).throw };
	}

	dispatchOnAdverb { |method ... arguments|
		var selector = method.name, adverbSelector, adverb = arguments.last;
		^ case
		
		{ this.respondsTo (adverbSelector = [selector, adverb.asString.toUpper1st].join.asSymbol) }
		{ this.perform (adverbSelector, * arguments) }
		
		{ adverb.isNumber and: this.respondsTo (adverbSelector = [selector, "N"].join.asSymbol) }
		{ this.perform (adverbSelector, * arguments) }

		{ Error ("Unable to dispatchOnAdverb for " ++ selector ++ "." ++ adverb ++ " and " ++ arguments).throw };
	}

	postfln { |format ... arguments|
		(format ++ "\n").postf (this, * arguments);
	}

	tap { |function|
		function.value (this);
		^ this;
	}

	nonZero { |epsilon|
		^ this.isZero (epsilon).not;
	}

	notZero { |epsilon|
		^ this.isZero (epsilon).not;
	}
	
	isZero {
		^ false;
	}

	isTrue {
		^ false;
	}

	isFalse {
		^ false;
	}

	isNothing {
		^ false;
	}

	isChan {
		^ false;
	}

	asPattern {
		^ Pn (this);
	}

	isLiteral {
		^ false;
	}

}
