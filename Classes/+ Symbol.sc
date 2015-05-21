+ Symbol {

	name {
		^ this;
	}

	toLower1st {
		^ this.asString.toLower1st.asSymbol;
	}

	toUpper1st {
		^ this.asString.toUpper1st.asSymbol;
	}

}
