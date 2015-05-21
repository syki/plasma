/******************************************************************************\

@class Base

Mathematics in base-N.

\******************************************************************************/

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

	/**************************************************************************\

	@method wrap
	@param n The input to scale.
	@returns The input scaled to the range (1 .. base).

	Useful for things like just intonation to restrict an interval to the octave, e.g.

		var base2 = Base (2);
		var perfect5th = 3/2;
		base2.wrap (perfect5th ** (1..4));
		// -> [ 1.5, 1.125, 1.6875, 1.265625]

	\**************************************************************************/

	wrap { |n|
		^ this.exp (this.log (n) % 1);
	}

}
