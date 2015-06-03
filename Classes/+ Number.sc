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
		^ this.abs < epsilon;
	}

	nonZero { |epsilon|
		^ this.isZero (epsilon).not;
	}

	notZero { |epsilon|
		^ this.isZero (epsilon).not;
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

	bifactors {
		var set = this.factors;
		var powerset = set.powerset[1..]; // Exclude the empty set...
		^ powerset.collect { |subset|
			[ subset.product, set.difference (subset).product ].sort;
		}.uniq.sortBy (0);
	}

}
