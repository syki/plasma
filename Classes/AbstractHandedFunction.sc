AbstractHandedFunction : AbstractFunction {
	
	composeUnaryOp { |operator|
		^ this.classUnaryOp.new (operator, this);
	}

	composeBinaryOp { |operator, that, adverb, hand|
		^ this.classBinaryOp.new (operator, this, that, adverb, hand);
	}

	reverseComposeBinaryOp { |operator, that, adverb, hand|
		^ this.classBinaryOp.new (operator, that, this, adverb, hand);
	}

	composeNAryOp { |operator, arguments|
		^ this.classNAryOp.new (operator, this, arguments);
	}

*	classUnaryOp {
		^ this.subclassResponsibility (thisMethod);
	}

	classUnaryOp {
		^ this.class.classUnaryOp;
	}

*	classBinaryOp {
		^ this.subclassResponsibility (thisMethod);
	}

	classBinaryOp {
		^ this.class.classBinaryOp;
	}

*	classNAryOp {
		^ this.subclassResponsibility (thisMethod);
	}

	classNAryOp {
		^ this.class.classNAryOp;
	}

	>@ { |that, adverb| ^ this.composeBinaryOp ('@', that, adverb, \left) }
	>+ { |that, adverb| ^ this.composeBinaryOp ('+', that, adverb, \left) }
	>- { |that, adverb| ^ this.composeBinaryOp ('-', that, adverb, \left) }
	>* { |that, adverb| ^ this.composeBinaryOp ('*', that, adverb, \left) }
	>/ { |that, adverb| ^ this.composeBinaryOp ('/', that, adverb, \left) }

	@< { |that, adverb| ^ this.composeBinaryOp ('@', that, adverb, \right) }
	+< { |that, adverb| ^ this.composeBinaryOp ('+', that, adverb, \right) }
	-< { |that, adverb| ^ this.composeBinaryOp ('-', that, adverb, \right) }
	*< { |that, adverb| ^ this.composeBinaryOp ('*', that, adverb, \right) }
	/< { |that, adverb| ^ this.composeBinaryOp ('/', that, adverb, \right) }

}
