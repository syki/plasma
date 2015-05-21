+ Routine {

	inject { |thisValue, function|
		this.do { |element| thisValue = function.value (thisValue, element); }
		^ thisValue;
	}

}
