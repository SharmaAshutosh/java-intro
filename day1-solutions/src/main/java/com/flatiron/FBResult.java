package com.flatiron;

public class FBResult {
    private final String output;
    private final long requestNumber;
    
    public FBResult(String output, long requestNumber) {
        this.output = output;
        this.requestNumber = requestNumber;
    }
    
    public String getOutput() {
        return output;
    }
    public long getRequestNumber() {
        return requestNumber;
    }

    @Override
    public String toString() {
        return "FBResult [output=" + output + ", requestNumber=" + requestNumber + "]";
    }
    
}
