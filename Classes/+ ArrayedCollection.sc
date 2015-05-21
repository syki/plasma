+ ArrayedCollection {
	
	putAll { |... collections|
		collections.do (_.indicesValuesDo (this.put (_, _)));
	}

	fillWith { |each|
		this.indicesDo { |i| this.put (i, each.(i)) };
	}

}
