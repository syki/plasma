PtieStream : PslurStream {

	embedInStream { |inEvent|
		unless (this.proceed (inEvent)) { ^ currEvent.yield };

		loop {
			currEvent = nextEvent;
			currKernel = nextKernel;

			unless (this.proceed (inEvent)) { ^ currEvent.yield };
			while { currKernel == nextKernel } {
				currEvent.use {
					~dur = ~dur + nextEvent.dur;
					~legato = (1 + ~legato) / 2;
				};
				unless (this.proceed (inEvent)) { ^ currEvent.yield };
			};

			inEvent = currEvent.yield;
		}
	}
	
}
