+ Stream {

	copySeries { |first, second, last|
		^ this.nextN (last + 1).copySeries (first, second, last);
	}

	doWith { |event, function|
		^ this.do (function, event);
	}

	doWithIndex { |function|
		var item, i = 0;
		while {
			item = this.next (i, i + 1);
			item.notNil;
		}{
			function.(item, i);
			i = i + 1;
		};
	}

	inject { |thisValue, function|
		this.do { |element| thisValue = function.value (thisValue, element); }
		^ thisValue;
	}

}
