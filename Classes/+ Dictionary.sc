+ Dictionary {

*	newFromKeys { |keys, valueFunction|
		^ this.newFromKeysValues (keys, keys.collect (valueFunction));
	}

*	newFromKeysValues { |keys, values|
		^ this.newFrom ([keys, values].lace);
	}

	compactInPlace {
		this.keysValuesDo { |key, value| if (value.isNothing) { this.remove (key) } };
	}

	valueAt { |key|
		^ this.at (key).value;
	}

	valueEnvirAt { |key|
		^ this.at (key).valueEnvir;
	}

	valueAtAll { |keys|
		^ this.atAll (keys).collect (_.value);
	}

	valueEnvirAtAll { |keys|
		^ this.atAll (keys).collect (_.valueEnvir);
	}

	asPmonopoly {
		^ this.asPbind.asPmonopoly;
	}

	asPbind {
		^ Pbind (* this.getPairs);
	}

	asPblur { |... keys|
		^ this.asPbind.asPslur (* keys).asPmonopoly;
	}

	++ { |that|
		^ this.copy.putAll (that);
	}

}
