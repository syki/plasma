+ HIDElementProto {
	
	addDictionaryMatch { |dict|
		dict.keysValuesDo { |key, value|
			this.perform (key.asSetter, value);
		}
	}

	matches { |elem|
		^ shouldMatch.every { |key|
			var value = this.perform (key);
			if (value.isNil) { true } {
				switch (key)
					{ \usageMin } { elem.usage >= value }
					{ \usageMax } { elem.usage <= value }
					{ elem.perform (key).matchItem (value) }
			};
		};
	}

}
