+ Pattern {

*	fibonacci {
		^ Precurring (#[1, 1], _ + _);
	}

*	fill { |... arguments|
		^ this.dispatchOnArity (thisMethod, * arguments);
	}
	
*	fill1 { |filler|
		^ Pseries.new.collect (filler);
	}

*	fillN { |count, filler|
		^ Pseries.new (length: count).collect (filler);
	}

	at { |index|
		var stream = this.asStream;
		index.do { stream.next };
		^ stream.next;
	}

	copySeries { |first, second, last|
		^ this.asStream.copySeries (first, second, last);
	}

	replace { |find, replace|
		find = find.asArray;
		^ this.collect { |it| if (find.includes (it)) { replace } { it } };
	}

	inject { |... arguments|
		^ this.asStream.inject (* arguments);
	}

	running { |... arguments|
		^ Prunning (this, * arguments);
	}

	moving { |... arguments|
		^ Pmoving (this, * arguments);
	}

	pairwise { |... arguments|
		^ this.moving (2, * arguments);
	}

	ratios {
		^ this.pairwise.ratio;
	}

	differences {
		^ this.pairwise.difference;
	}

	keeps { |counts|
		^ Pkeeps (counts, this);
	}

	drops { |counts|
		^ Pdrops (counts, this);
	}

	half {
		^ this / 2;
	}

	inv {
		^ 1 / this;
	}

	unv { // Unitary inversion, or unversion.
		^ 1 - this;
	}

	madd { |mul = 1, add = 0|
		^ this * mul + add;
	}

	tied { |... keys|
		^ this.asPtie (* keys);
	}

	slurred { |... keys|
		^ this.asPslur (* keys);
	}

	asPtie { |... keys|
		^ Ptie (this, * keys);
	}

	asPslur { |... keys|
		^ Pslur (this, * keys);
	}

	asPmonopoly {
		^ Pmonopoly (this);
	}

	isRestify {
		^ this.collect (_.isZero);
	}

	freqify {
		^ this.replace (0, \rest);
	}

	asPattern {
		^ this;
	}

}
