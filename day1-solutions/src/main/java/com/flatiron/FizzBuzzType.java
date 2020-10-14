package com.flatiron;

public enum FizzBuzzType {
    STANDARD(new FizzBuzzService(new FBConfig(3,5))), 
    ALWAYS_BUZZ(new AlwaysBuzzService());
    
    private FizzBuzzable fb;
    
	private FizzBuzzType(FizzBuzzable fb) {
        this.fb = fb;
    }
    public FizzBuzzable getFb() {
		return fb;
	}
}
