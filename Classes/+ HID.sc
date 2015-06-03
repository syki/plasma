+ HID {
	
	asHIDProto {
		^ HIDProto.newFromDict (this.asHIDProtoDict);
	}

	asHIDProtoDict {
		^ this.info.asHIDProtoDict;
	}

}
