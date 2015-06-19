AddOut : Out {
	
*	ar { |bus = 0, level = 1, channelsArray|
		^ if (1 === level)
			{ super.ar (bus, channelsArray) }
		    { this.ar (bus, level * channelsArray) };
	}

*	kr { |bus = 0, level = 1, channelsArray|
		^ if (1 === level)
			{ super.kr (bus, channelsArray) }
		    { this.kr (bus, level * channelsArray) };
	}

}
