Pcalypso : Pattern {

	var < steps, < notes, < phase, < perBar, < perBeat;

*	new { |steps, notes, phase, perBar, perBeat|
		if (perBar.respondsTo (\asPbind)) { perBar = perBar.asPbind };
		if (perBeat.respondsTo (\asPbind)) { perBeat = perBeat.asPbind };
		^ super.newCopyArgs (steps, notes, phase ? 0, perBar, perBeat);
	}

	storeArgs {
		^ [steps, notes, phase, perBar, perBeat];
	}

	embedInStream { |event|
		var all = this.createEvent, bar, beat, beatWas;
		var perBar = this.perBar.asStream;
		var perBeat = this.perBeat.asStream;
		var pattern, i = 0;

		loop {
			{ bar = perBar.next (all) }.if (i == 0);
			beat = perBeat.next (bar);
			{ pattern = this.createPatternWithEnvir (beat) }.if (beat != beatWas);
			pattern[i].yield;
			beatWas = beat;
			i = pattern.wrapIndex (i + 1);
		}

		^ event;
	}
	
	createEvent {
		^ (steps: steps, notes: notes, phase: phase);
	}

	createPatternWithEnvir { |envir|
		^ Array.performWithEnvir (\calypso, envir);
	}

}
