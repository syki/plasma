Pdrops : FilterPattern {

	var <> counts;

*	new { |counts, pattern|
		^ super.new (pattern).counts_ (counts);
	}

	storeArgs {
		^ [counts, pattern];
	}
	
	embedInStream { |event|
		var count, county = counts.asStream;
		while { (count = county.next).notNil } {
			pattern.drop (count).embedInStream (event);
		};
		^ event;
	}

}
