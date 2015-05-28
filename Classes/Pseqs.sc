Pseqs : ListsPattern {
	
	var <> offset;

*	new { |lists, repeats = 1, offset = 0|
		^super.new (lists, repeats).offset_ (offset);
	}

	storeArgs {
		^ [lists, repeats, offset];
	}

	embedInStream { |event|
		var do = if (event.eventAt (\reverse).isTrue) { \reverseDo } { \do };
		var offset = this.offset.(event);
		var repeats = this.repeats.(event);

		repeats.do {
			var nothingHappened = true;
			this.run (event) { |list|
				nothingHappened = false;
				list.size.perform (do) { |i|
					event = list.wrapAt (i + offset).embedInStream (event);
				}
			};
			if (nothingHappened) { ^ event };
		}
		^ event;
	}

	run { |event, function|
		lists.asStream.doWith (event, function);
	}

}
