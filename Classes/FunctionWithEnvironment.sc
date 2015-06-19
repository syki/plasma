FunctionWithEnvironment : AbstractFunction {
	
	var < function, < environment;

*	new { |function, environment|
		^ super.newCopyArgs (function, ());
	}

	value { |... arguments|
		^ this.valueArray (arguments);
	}

	valueEnvir { |... arguments|
		^ this.valueArrayEnvir (arguments);
	}

	valueArray { |arguments|
		arguments ?? { arguments = [] };
		^ environment.use { function.valueArray (arguments) };
	}

	valueArrayEnvir { |arguments|
		arguments ?? { arguments = [] };
		^ (environment ++ currentEnvironment).use { function.valueArrayEnvir (arguments) };
	}

	buildForProxy { |... arguments|
		^ environment.use { function.buildForProxy (* arguments) };
	}

}
