+ Boolean {
	
	unless { |trueFunc, falseFunc|
		^ this.not.if (trueFunc, falseFunc);
	}

}
