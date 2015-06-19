+ Collection {

	singleton {
		this.do { |item| ^ item };
	}
	
	isSingleton {
		^ 1 == this.size;
	}

	isDoubleton {
		^ 2 == this.size;
	}

	isTripleton {
		^ 3 == this.size;
	}

	isPair {
		^ this.isDoubleton;
	}

	compact {
		^ this.reject (_.isNothing);
	}

	asOdd {
		^ this.asEven + 1;
	}

	asEven {
		^ this * 2;
	}

	inc { |amount = 1|
		^ this + amount;
	}

	dec { |amount = 1|
		^ this - amount;
	}

	half {
		^ this.collect (_ / 2);
	}

	inv {
		^ 1 / this;
	}

	unv { // Unitary inversion, or unversion.
		^ 1 - this;
	}

	+/ { |that|
		^ (this + that) / that;
	}

	uniq {
		^ this.class.newFrom (Set.newFrom (this));
	}

	except { |element|
		^ this.reject (_ == element);
		// It would be nice to accomodate > 1 elements, but can't use anything like:
		//     ^ this.reject (elements.includes (_))`
		// Because it doesn't seem to work for strings.
	}

	tryDo { |tryFunc, catchFunc|
		this.do { |... arguments|
			{ tryFunc.(* arguments) }.try (catchFunc);
		}
	}

	replace { |find, replace|
		find = find.asArray;
		^ this.collect { |it| if (find.includes (it)) { replace } { it } };
	}

	isNothing {
		^ this.isEmpty;
	}

	isRestify {
		^ this.collect (_.isZero);
	}

	freqify {
		^ this.replace (0, \rest);
	}

}
