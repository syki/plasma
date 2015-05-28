+ SequenceableCollection {

	performBinaryOpOnSeqColl { |operator, that, adverb|
		^ this.dispatchOnAdverb (thisMethod, operator, that, adverb);
	}

	performBinaryOpOnSeqCollNil { |operator, that, adverb|
		var size = this.size max: that.size;
		var result = this.species.new (size);
		size.do ({ |i| result.add (that.wrapAt (i).perform (operator, this.wrapAt (i))) });
		^ result;
	}

	performBinaryOpOnSeqColl0 { |operator, that, adverb|
		var size = this.size max: that.size;
		var result = this.species.new (size);
		size.do ({ |i| result.add (that.wrapAt (i).perform (operator, this.wrapAt (i))) });
		^ result;
	}

	performBinaryOpOnSeqCollN { |operator, that, adverb|
		var d = if (adverb > 0) { 1.neg } { 1 };
		^ that.collect { |item, i| item.perform (operator, this, adverb + d) }
	}

	performBinaryOpOnSeqCollT { |operator, that, adverb|
		var size = that.size;
		var result = this.species.new (size);
		size.do ({ |i| result.add (that.at (i).perform (operator, this)) });
		^ result;
	}

	performBinaryOpOnSeqCollX { |operator, that, adverb|
		var size = that.size * this.size;
		var result = this.species.new (size);
		that.do ({ |a| this.do ({ |b| result.add (a.perform (operator, b)) }) });
		^ result;
	}

	performBinaryOpOnSeqCollS { |operator, that, adverb|
		var size = this.size min: that.size;
		var result = this.species.new (size);
		size.do ({ |i| result.add (that.wrapAt (i).perform (operator, this.wrapAt (i))) });
		^ result;
	}

	performBinaryOpOnSeqCollF { |operator, that, adverb|
		var size = this.size max: that.size;
		var result = this.species.new (size);
		size.do ({ |i| result.add (that.foldAt (i).perform (operator, this.foldAt (i))) });
		^ result;
	}

	performBinaryOpOnSeqCollR { |operator, that, adverb|
		var m = this.size, n = that.size;
		var size = m * n / m.gcd (n);
		var result = this.species.new (size);
		size.do ({ |i| result.add (that.wrapAt (i).perform (operator, this.wrapAt (i))) });
		^ result;
	}

}
