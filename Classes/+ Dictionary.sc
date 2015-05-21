+ Dictionary {

	asPbind {
		^ Pbind (* this.getPairs);
	}
	
	asPmono {
		^ Pmono (this[\instrument], * this.getPairs);
	}

	asPmonoArtic {
		^ PmonoArtic (this[\instrument], * this.getPairs);
	}

}
