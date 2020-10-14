package com.flatiron;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SampleClass {
    public static void main(String[] args) {
    	
    	//initial version
        for(int i = 0; i < 100; i++) {
            if(i % 3 == 0 && i % 5 ==0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
        
        //slightly harder version
        Map<Integer, String> fizmap = new HashMap<>();
        for(int i = 0; i < 100; i++) {
            if(i % 3 == 0 && i % 5 ==0) {
                fizmap.put(i, "FizzBuzz");
            } else if (i % 3 == 0) {
                fizmap.put(i, "Fizz");
            } else if (i % 5 == 0) {
                fizmap.put(i, "Buzz");
            } else {
                fizmap.put(i, Integer.toString(i));
            }
        }
        
        for(int i = 0; i < 100; i++) {
            System.out.println(fizmap.get(i));
        }
        
        
        List<String> output = List.of(5,1,3,2,1).stream()
                .sorted()
                .map(i -> {
                    if(i % 3 == 0 && i % 5 ==0) {
                        return "FizzBuzz";
                    } else if (i % 3 == 0) {
                        return "Fizz";
                    } else if (i % 5 == 0) {
                        return "Buzz";
                    } else {
                        return Integer.toString(i);
                    }})
                .collect(Collectors.toList());
        
        //Reusing a function
        Function<Integer,String> fizzBuzz = (i -> { 
            if(i % 3 == 0 && i % 5 ==0) {
                return "FizzBuzz";
            } else if (i % 3 == 0) {
                return "Fizz";
            } else if (i % 5 == 0) {
                return "Buzz";
            } else {
                return Integer.toString(i);
            }
        });
        
        //stream
        IntStream.range(1, 101).boxed().map(fizzBuzz).collect(Collectors.toList());
        
    }
}
