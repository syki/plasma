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

	half {
		^ this.collect (_ / 2);
	}

	inv {
		^ 1 / this;
	}

	unv { // Unitary inversion, or unversion.
		^ 1 - this;
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

	isNothing {
		^ this.isEmpty;
	}

}
