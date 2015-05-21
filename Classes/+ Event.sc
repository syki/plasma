+ Event {
	
	with { |... arguments|
		^ this.dispatchOnArity (thisMethod, * arguments);
	}

	with1 { |event|
		^ Event (8, event, this);
	}

	withN { |... pairs|
		^ with1 (Event.newFrom (pairs));
	}

}
