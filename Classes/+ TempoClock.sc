+ TempoClock {
	
	schedNextBar { |task|
		this.schedAbs (this.nextBar, task);
	}

	asOfNextBar { |beatsPerBar, beatsPerMinute, beatsPerSecond, tempo|
		this.schedNextBar {
			beatsPerBar.notNil.if    { this.beatsPerBar_ (beatsPerBar);       };
			beatsPerMinute.notNil.if { this.beatsPerMinute_ (beatsPerMinute); };
			beatsPerSecond.notNil.if { this.beatsPerSecond_ (beatsPerSecond); };
			tempo.notNil.if          { this.tempo_ (tempo);                   };
		};
	}

	beatsPerSecond {
		^ this.tempo;
	}

	beatsPerSecond_ { |value|
		^ this.tempo_ (value);
	}

	beatsPerMinute {
		^ this.tempo * 60;
	}

	beatsPerMinute_ { |value|
		^ this.tempo_ (value / 60);
	}

}
