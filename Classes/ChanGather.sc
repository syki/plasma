ChanGather : ChanFunction { 

	var source, predicate;

	arguments_ { |arguments|
		# source, predicate = arguments;
	}

	load {
		var result;
		source.do { |value|
			if (predicate.(value)) {
				result ?? {
					result = Chan.new (source.value);
					this.put (result);
				};
				result.put (value);
			} {
				result.put (nil);
				result = nil;
			}
		}
	}	

}
