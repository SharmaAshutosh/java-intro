package com.flatiron;

public class FBConfig {
    
    private int fizz;
    private int buzz;
    
    public FBConfig(int fizz, int buzz) {
        this.fizz = fizz;
        this.buzz = buzz;
    }
    public int getFizz() {
        return fizz;
    }
    public void setFizz(int fizz) {
        this.fizz = fizz;
    }
    public int getBuzz() {
        return buzz;
    }
    public void setBuzz(int buzz) {
        this.buzz = buzz;
    }
    
}
