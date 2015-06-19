+ SequenceableCollection {

*	cat { |... arguments|
		^ arguments.reduce (_ ++ _);
	}

	singleton {
		^ this.first;
	}

	flip { // A non-wrapping flop.
		^ this.flipWithArray { |array| array };
	}

	flipWith { |function| // A non-wrapping flopWith.
		var size = this.maxValue { |kid| if (kid.isSequenceableCollection) { kid.size } { 1 } };
		^ this.species.fill (size, { |i|
			var arguments = Array (this.size);
			this.do { |kid|
				arguments = if (kid.isSequenceableCollection) {
					if (i < kid.size) { arguments.add (kid.at (i)) } { arguments };
				} {
					arguments.add (kid);
				};
			};
			function.value (* arguments);
		});
	}

	flipWithArray { |function| // A flippy splat.
		^ this.flipWith { |... arguments| function.value (arguments); };
	}

	keepUntilNil {
		^ this.keepUntil (_.isNil);	
	}

	keepUntilZero {
		^ this.keepUntil (_.isZero);	
	}

	keepUntil { |predicate|
		^ this.keep (this.detectIndex (predicate));
	}

	keepWhile { |predicate|
		^ this.keepUntil (predicate.not);
	}

	dropUntil { |predicate|
		^ this.drop (this.detectIndex (predicate));
	}

	dropWhile { |predicate|
		^ this.dropUntil (predicate.not);
	}

	dropWhileNil {
		^ this.dropWhile (_.isNil);
	}

	dropWhileZero {
		^ this.dropWhile (_.isZero);
	}

	indexOfNil {
		^ this.indexOfEqual (nil);
	}

	indexOf0 {
		^ this.indexOfEqual (0);
	}

	indexOf1 {
		^ this.indexOfEqual (1);
	}

	indicesOfNil {
		^ this.indicesOfEqual (nil);
	}

	indicesOf0 {
		^ this.indicesOfEqual (0);
	}

	indicesOf1 {
		^ this.indicesOfEqual (1);
	}

	indicesDo { |each|
		this.size.do (each);
	}

	indicesValuesDo { |each|
		this.do { |e, i| each.(i, e) };
	}

	indicesValues {
		^ IdentityDictionary.newFromKeys ((0..this.size), this[_]);
	}

	wrapIndex { |index|
		^ index % this.size;
	}

	asPseq { |... arguments|
		^ Pseq (this, * arguments);
	}

	gather { |predicate|
		var result = this.species.new, results = this.species.new;
		var append = { unless (result.isEmpty) { results = results.add (result) } };
		predicate ?? { predicate = (_.notNil) };
		this.do { |item|
			result = if (predicate.value (item)) {
				result.add (item);
			} {
				append.value;
				this.species.new;
			};
		};
		append.value;
		^ results;
	}

	gesture {
		^ this.gather { |argument| argument.notNil and: argument.nonZero };
	}

	asBigEndianInteger {
		^ this.reverse.asLittleEndianInteger;
	}

	asLittleEndianInteger {
		^ this.collect { |n, i| 1 << i * n }.sum;
	}

}
