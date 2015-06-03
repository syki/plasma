Pmonopoly : FilterPattern {
	
	embedInStream { |inEvent|
		^ PmonopolyStream (this).embedInStream (inEvent);
	}

}
