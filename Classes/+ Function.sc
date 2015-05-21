+ Function {

	if { |condition|
		^ condition.if (this);
	}
	
	precollect { |function|
		^ { |... arguments| this.value (* arguments.collect (function)); }
	}

	ordinalize {
		^ this.precollect (_ + 1);
	}

	cardinalize {
		^ this.precollect (_ - 1);
	}

	deordinalize {
		^ this.cardinalize;
	}

	decardinalize {
		^ this.ordinalize;
	}

}
