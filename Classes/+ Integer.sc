+ Integer {
	
	isOdd {
		^ this.odd;
	}

	isEven {
		^ this.even;
	}

	isLiteral {
		^ true;
	}

	asBigEndianDigits {
		^ 32.collect { |i| 1 << i & this >> i }.reverse.dropWhileZero;
	}

	asLittleEndianDigits {
		^ this.asBigEndianDigits.reverse;
	}

}
