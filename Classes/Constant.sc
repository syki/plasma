Constant {
	
	classvar < rateSelectorsNames, < rateNamesSelectors, rateNameSelectorPairs;

*	initClass {
		rateNameSelectorPairs = #[ audio, ar, control, kr, demand, dr, scalar, ir, trigger, tr ];
		rateNamesSelectors = IdentityDictionary.newFrom (rateNameSelectorPairs);
		rateSelectorsNames = rateNamesSelectors.invert;
	}

}
