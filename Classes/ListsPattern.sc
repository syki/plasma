ListsPattern : Pattern {

	var <> lists, <> repeats = 1;

*	new { |lists, repeats = 1|
		^ super.new.lists_ (lists).repeats_ (repeats);
	}

	copy {
		^ super.copy.lists_ (lists.copy);
	}
	
	storeArgs {
		^ [lists, repeats];
	}

}
