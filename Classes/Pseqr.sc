Pseqr : Pseqs {
	
*	new { |lists, repeats = 1, offset = 0|
		if (lists.isFunction) { lists = Prout (lists) };
		^ super.new (lists, repeats, offset);
	}

}
