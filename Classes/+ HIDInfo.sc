+ HIDInfo {
	
	asHIDProto {
		^ HIDProto.newFromDict (this.asHIDProtoDict);
	}

	asHIDProtoDict {
		var keys = #[
			vendorID, productID,
			interfaceNumber, releaseNumber, serialNumber,
			usagePage, usage,
			path
		];
		^ Dictionary.newFromKeys (keys, this.perform (_)).compact;
	}

}
