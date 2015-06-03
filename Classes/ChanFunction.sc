ChanFunction : Chan {
	
*	new { |... arguments|
		^ super.new.arguments_ (arguments).initializeValue.load;
	}

	arguments_ { |arguments|
		^ this.subclassResponsibility (thisMethod);
	}

	load {
		^ this.subclassResponsibility (thisMethod);
	}

}
