ChildStream : Stream {
	
	var parent;

*	new { |parent|
		^ super.newCopyArgs (parent)
	}

	storeArgs {
		^ [parent];
	}

}
