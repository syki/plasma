Base {

	var < base, < baseLog;

*	new { |base = 2.718281828459|
		^ super.newCopyArgs (base, base.log);
	}

	log { |n|
		^ n.log / baseLog;
	}

	exp { |n|
		^ base ** n;
	}

	wrap { |n|
		^ this.exp (this.log (n) % 1);
	}

}
