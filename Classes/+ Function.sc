+ Function {

	if { |condition|
		^ condition.if (this);
	}

	unless { |condition|
		^ condition.unless (this);
	}

	debounce { |delay = 1|
		var then = 0;
		^ { |... arguments|
			var now = SystemClock.seconds;
			if (now - then > delay) {
				then = now;
				this.valueEnvir (* arguments);
			};
		}
	}

}
