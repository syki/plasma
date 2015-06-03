+ Polar {
	
*	epsilon {
		^ this.new (0, 0);
	}

	epsilon {
		^ this.class.new (rho.epsilon, theta.epsilon);
	}

*	zero {
		^ this.new (0, 0);
	}

	zero {
		^ this.class.new (rho.zero, theta.zero);
	}

	isZero {
		^ rho.isZero;
	}

}
