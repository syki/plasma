+ HIDProto {

	addDictionaryMatch { |dict|
		dict.keysValuesDo { |key, value|
			shouldMatch.add (key);
			this.perform (key.asSetter, value);
		}
	}
	
}
