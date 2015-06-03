+ Complex {
	
*	epsilon {
		^ this.new (0, 0);
	}

	epsilon {
		^ this.class.new (real.epsilon, imag.epsilon);
	}

*	zero {
		^ this.new (0, 0);
	}

	zero {
		^ this.class.new (real.zero, imag.zero);
	}

}
