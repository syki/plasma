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

}
