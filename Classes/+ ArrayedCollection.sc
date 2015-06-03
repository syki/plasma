+ ArrayedCollection {
	
	putAll { |... collections|
		collections.do (_.indicesValuesDo (this.put (_, _)));
	}

	fillWith { |each|
		this.indicesDo { |i| this.put (i, each.(i)) };
	}

	second {
		^ this[1];
	}

	third {
		^ this[2];
	}

	first_ { |value|
		this[0] = value;
	}

	second_ { |value|
		this[1] = value;
	}

	third_ { |value|
		this[2] = value;
	}

	last_ { |value|
		this[this.size - 1] = value;
	}

}
