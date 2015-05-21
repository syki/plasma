+ SequenceableCollection {

*	cat { |... arguments|
		^ arguments.reduce (_ ++ _);
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

	wrapIndex { |index|
		^ index % this.size;
	}

}
