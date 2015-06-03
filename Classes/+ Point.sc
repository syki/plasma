+ Point {

*	epsilon {
		^ this.new (0, 0);
	}

*	zero {
		^ this.new (0, 0);
	}

	isZero { |epsilon|
		epsilon = epsilon ?? { this.class.epsilon };
		^ this.abs < epsilon;
	}

	nonZero { |epsilon|
		^ this.isZero (epsilon).not;
	}

	notZero { |epsilon|
		^ this.isZero (epsilon).not;
	}

	< { |that|
		^ (this.x < that.x) and: { this.y < that.y };
	}

	> { |that|
		^ (this.x > that.x) and: { this.y > that.y };
	}

}
