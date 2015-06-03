+ HIDElement {
	
	asHIDElementProto {
		^ HIDElementProto.newFromDict (this.asHIDElementProtoDict);
	}

	asHIDElementProtoDict {
		var keys = #[
			id,
			usagePage, usage
		];
		^ Dictionary.newFromKeys (keys, this.perform (_)).compact;
	}

}
