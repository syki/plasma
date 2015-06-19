PmonopolyStream : FilterPatternStream {

	var currentID, currentServer;
	var	finally, finalFunction;

	populateEventFromSynthDesc { |event|
		event.populateFromSynthDesc;
	}

	populateEventFromCurrents { |event|
		event.use { ~id = currentID; ~server = currentServer; };
	}

	populateEventWithDefaults { |event|
		event.use {
			~sustain = ~sustain.value ? event.delta;
			~type = \monoSet;
		};
	}

	populateEvent { |event|
		this.populateEventFromSynthDesc (event);
		this.populateEventFromCurrents (event);
		this.populateEventWithDefaults (event);
	}

	addFinalFunction { |event|
		this.setFinalFunction (event);
		finally.addFunction (event, finalFunction);
	}

	setFinalFunction { |event|
		finalFunction = this.createFinalFunction (event);
	}

	createFinalFunction { |event|
		^ { |maybe|
			if (maybe) { this.playFinalEvent (event) };
			finalFunction = nil;
		}
	}

	createFinalEvent { |event|
		^ event.with (( type: \off, id: currentID, server: currentServer ));
	}

	playFinalEvent { |event|
		this.createFinalEvent (event).play;
	}

	beginVoice { |event|
		event.use {
			unless (event.isRest) {
				~type = \monoNote;
				this.addFinalFunction (event);
			};
			~updatePmono = { |... currents| # currentID, currentServer = currents };
		};
	}

	endVoice { |event|
		event.use {
			~removeFromCleanup = ~removeFromCleanup.add (finalFunction);
			thisThread.clock.sched (event.sustain) { finalFunction.value (true) };
		}
	}

	embedInStream { |inEvent|
		var outEvent;
		var rearticulating = true;

		finally = EventStreamCleanup.new;

		while {
			outEvent = stream.next (inEvent);
			outEvent.notNil;
		} {
			this.populateEvent (outEvent);

			if (rearticulating) {
				this.beginVoice (outEvent);
				rearticulating = false;
			};

			if (/* nextEvent.instrument != outEvent.instrument or: */ outEvent.sustain < outEvent.delta) {
				this.endVoice (outEvent);
				rearticulating = true;
			};

			finally.update (outEvent);
			inEvent = outEvent.yield;
		};

		^ finally.exit (inEvent);
	}

}
