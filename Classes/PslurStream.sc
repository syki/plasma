PslurStream : FilterPatternStream {

	var currKernel, currEvent;
	var nextKernel, nextEvent;

	keysForEvent { |event|
		^ parent.keys ?? { event.synthDesc.controlNames };
	}

	kernelForEvent { |event|
		^ event.usedValueEnvirAtAll (this.keysForEvent (event));
	}

	proceed { |event|
		nextEvent = stream.next (event) ?? { ^ currEvent.yield };
		nextEvent.populateFromSynthDesc;
		nextKernel = this.kernelForEvent (nextEvent);
		^ true;
	}

	embedInStream { |inEvent|
		unless (this.proceed (inEvent)) { ^ nil.yield };

		loop {
			currEvent = nextEvent;
			currKernel = nextKernel;

			unless (this.proceed (inEvent)) { ^ currEvent.yield };

			currEvent.use {
				~legato = if (currKernel == nextKernel) { ~legato max: 1.000 } { ~legato min: 0.999 };
			};
			inEvent = currEvent.yield;
		}
	}

}
