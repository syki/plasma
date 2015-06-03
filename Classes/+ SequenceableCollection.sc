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

}
