package com.flatiron;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FizzBuzzService implements FizzBuzzable {
    private int fizz;
    private int buzz;
    
    private static long totalRequests = 0;
    
    public FizzBuzzService(FBConfig config) {
        this.fizz = config.getFizz();
        this.buzz = config.getBuzz();
    }
    
    public FBResult fizzBuzz(int n) {
        return new FBResult(evaluate(n), totalRequests++);
    }
    
    private String evaluate(int i) {
        if(i % (fizz*buzz) == 0) {
            return "FizzBuzz";
        } else if (i % fizz == 0) {
            return "Fizz";
        } else if (i % buzz == 0) {
            return "Buzz";
        } else {
            return "" + i;
        }
    }
    
    public static void main(String[] args) {
    	//Minilab #3
        FizzBuzzService fbs = new FizzBuzzService(new FBConfig(3,5));
        IntStream.range(1, 101).mapToObj(i -> fbs.fizzBuzz(i)).forEach(System.out::println);
        
        //Minilab #4
        IntStream.range(1, 101).boxed()
        	.flatMap(i -> Stream.of(FizzBuzzType.values())
        						.map(fbType -> fbType.getFb().fizzBuzz(i)))
        	.forEach(System.out::println);
        
    }
    
}
