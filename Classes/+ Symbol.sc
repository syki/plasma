+ Symbol {

	name {
		^ this;
	}

	toLower {
		^ this.asString.toLower.asSymbol;
	}

	toUpper {
		^ this.asString.toUpper.asSymbol;
	}

	toLower1st {
		^ this.asString.toLower1st.asSymbol;
	}

	toUpper1st {
		^ this.asString.toUpper1st.asSymbol;
	}

	asRateName {
		^ Constant.rateSelectorsNames[this] ?
		  Constant.rateSelectorsNames[Constant.rateNamesSelectors [this]];
	}

	asRateSelector {
		^ Constant.rateNamesSelectors[this] ?
		  Constant.rateNamesSelectors[Constant.rateSelectorsNames [this]];
	}

	isLiteral {
		^ true;
	}

}
