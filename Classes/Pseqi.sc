Pseqi : Pseqs {
	
*	new { |lists, repeats = 1, offset = 0|
		if (lists.isFunction) { lists = Pattern.fill (lists) };
		^ super.new (lists, repeats, offset);
	}

}
