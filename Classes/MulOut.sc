MulOut : ReplaceOut {
	
*	ar { |bus = 0, level = 1, channelsArray|
		^ if (1 === level)
			{ super.ar (bus, In.ar (bus, channelsArray.size) * channelsArray) }
			{ this.ar (bus, level * (channelsArray - 1) + 1) };
	}

*	kr { |bus = 0, level = 1, channelsArray|
		^ if (1 === level)
			{ super.kr (bus, In.kr (bus, channelsArray.size) * channelsArray) }
			{ this.kr (bus, level * (channelsArray - 1) + 1) };
	}

}
