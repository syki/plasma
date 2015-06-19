+ Number {

*	epsilon {
		^ this.zero;
	}

	epsilon {
		^ this.class.epsilon;
	}

*	zero {
		^ this.subclassResponsibility (thisMethod);
	}

	zero {
		^ this.class.zero;
	}

	isZero { |epsilon|
		epsilon = epsilon ?? { this.epsilon };
		^ this.abs <= epsilon;
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

	sqr {
		^ this * this;
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

	divWithRemainder { |that|
		^ (this / that).floor.pair (this % that);
	}

	bifactors {
		var set = this.factors;
		var powerset = set.powerset[1..]; // Exclude the empty set...
		^ powerset.collect { |subset|
			[ subset.product, set.difference (subset).product ].sort;
		}.uniq.sortBy (0);
	}

}
