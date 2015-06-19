+ Environment {

	reuse { |... arguments|
		this.use (* arguments);
	}

	usedValueAt { |key|
		^ this.use { this.valueAt (key) };
	}

	usedValueEnvirAt { |key|
		^ this.use { this.valueEnvirAt (key) };
	}
	
	usedValueAtAll { |keys|
		^ this.use { this.valueAtAll (keys) };
	}

	usedValueEnvirAtAll { |keys|
		^ this.use { this.valueEnvirAtAll (keys) };
	}

}
