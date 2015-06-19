EventRedirect : Event {
	
	asString {
		^ this.class.name ++ super.asString;
	}

}