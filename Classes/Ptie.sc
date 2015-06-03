Ptie : Pslur {
	
	embedInStream { |inEvent|
		^ PtieStream (this).embedInStream (inEvent);
	}

}
