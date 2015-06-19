+ Point {

*	zero {
		^ this.new (0, 0);
	}

	isZero { |epsilon|
		var rho = this.rho;
		var eps = epsilon ?? { rho.epsilon };
		^ this.rho <= eps;
	}

}
