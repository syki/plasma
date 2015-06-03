+ List {

	size_ { |n = 0|
		var m = this.size;
		if (m > n) { this.removeAllSuchThat { |e, i| i >= n }; } { this.growClear ((n - m).asInteger); };
	}

	resize { |n = 0|
		^ this.size_ (n);
	}

	resized { |n = 0|
		^ this.copy.size_ (n);
	}

	growClear { |sizeIncrease|
		array = array.growClear (sizeIncrease);
	}

	// From plasma/Classes/ArrayedCollection.sc:

	putAll { |... collections|
		collections.do (_.indicesValuesDo (this.put (_, _)));
	}

	fillWith { |each|
		this.indicesDo { |i| this.put (i, each.(i)) };
	}

	// From plasma/Classes/Array.sc:

	derotate { |n|
		^ this.rotate (n.neg);
	}

	derotateInPlace { |n|
		^ this.rotateInPlace (n.neg);
	}

	rotateInPlace { |n|
		this.putAll (this.rotate (n));
	}

	riffle { |... arguments|
		^ this.reshape (* arguments).flop.flatten;
	}

	raffle { |i|
		var raffle = this.size.bifactors;
		raffle = raffle ++ raffle[1..].reverse.collect (_.reverse);
		^ this.riffle (* raffle.wrapAt (i));
	}
	
	partition { |l|
		if (l.isNegative) { l = this.size + l };
		^ [this.prefix (l), this.suffix (this.size - l)];
	}

	partitions { // All partitions including the trivial (partially empty) partitions at either end.
		^ { |i| this.partition (i) } ! (this.size + 1);
	}

	partitions1 { // All partitions with at least 1 element in either array.
		^ { |i| this.partition (i + 1) } ! (this.size - 1);
	}

	prefix { |l|
		^ if (0 == l) { [] } { this[0 .. l - 1] };
	}

	prefixes { // All prefixes including the empty array.
		^ { |i| this.prefix (i) } ! (this.size + 1);
	}

	prefixes1 { // All prefixes with at least 1 element.
		^ { |i| this.prefix (i + 1) } ! (this.size);
	}

	suffix { |l|
		^ if (0 == l) { [] } { this[this.size - l..] };
	}

	suffixes { // All suffixes including the empty array.
		^ { |i| this.suffix (i) } ! (this.size + 1);
	}

	suffixes1 { // All suffixes with at least 1 element.
		^ { |i| this.suffix (i + 1) } ! (this.size);
	}
	
}
