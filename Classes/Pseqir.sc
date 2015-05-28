Pseqir : Pseqr {

	run { |event, function|
		lists.asStream.doWithIndex (function);
	}
	
}
