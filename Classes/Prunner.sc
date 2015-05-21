Prunner : FilterPattern {

	embedInStream { |event|
		this.shouldNotImplement (thisMethod);
	}
	
	total {
		^ this.sum;
	}

	sum {
		^ Prunning (pattern, _ + _);
	}

	product {
		^ Prunning (pattern, _ * _);
	}

}
