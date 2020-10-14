package com.flatiron;

public class AlwaysBuzzService implements FizzBuzzable {
    private static long num = 0; 

    @Override
    public FBResult fizzBuzz(int n) {
        return new FBResult("Buzz", num++);
    }

}
