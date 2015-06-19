+ AbstractFunction {
	
	asPfunc { |... arguments|
		^ Pfunc (this, * arguments);
	}

	asOdd {
		^ this.asEven + 1;
	}

	asEven {
		^ this * 2;
	}

	inc { |amount = 1|
		^ this + amount;
	}

	dec { |amount = 1|
		^ this - amount;
	}

	+/ { |that|
		^ (this + that) / that;
	}

	divWithRemainder { |that|
		^ (this / that).floor.pair (this % that);
	}

	x { ^ this.composeUnaryOp ('x'); }
	y { ^ this.composeUnaryOp ('y'); }

	sqr {
		^ this * this;
	}

}
