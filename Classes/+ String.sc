+ String {

	name {
		^ this;
	}
	
	toClassName {
		var apostrophes = "'";
		var words =
			"[A-Z][a-z]+"  +|+ // The
			"[A-Z]+"       +|+ // THE
			"[a-z]+"       +|+ // the
			"[0-9]+[A-Z]+" +|+ // 9TH
			"[0-9]+[a-z]+" +|+ // 9th
			"[0-9]+";          // 123

		^ this
			.replace (apostrophes, "")
			.findRegexp (words).flop[1]
			.collect (_.toLower)
			.collect (_.toUpper1st)
			.join;
	}

	toMethodName {
		^ this.toClassName.toLower1st;
	}

	toLower1st {
		^ this[0].toLower ++ this[1..];
	}

	toUpper1st {
		^ this[0].toUpper ++ this[1..];
	}

	+|+ { |that|
		^ this ++ if (this.last == $| or: { that.first == $|; }) { that; } { $| ++ that; };
	}

	isNothing {
		^ this.isEmpty;
	}

}
