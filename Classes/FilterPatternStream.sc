FilterPatternStream : ChildStream {
	
	var <> pattern, <> stream;

*	new { |parent|
		^ super.new (parent).pattern_ (parent.pattern).stream_ (parent.pattern.asStream);
	}

}
