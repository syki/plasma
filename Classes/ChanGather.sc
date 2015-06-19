ChanGather : Chan { 

	var source, predicate;

	arguments_ { |arguments|
		# source, predicate = arguments;
	}

	prepare {
		var result;
		source.do { |inValue|
			if (inValue.isNil) { ^ this.finish };
			if (predicate.(inValue)) {
				result ?? {
					result = Chan.new (inValue);
					this.put (result);
				};
				result.put (inValue);
			} {
				result.put (nil);
				result = nil;
			}
		}
	}	

}
