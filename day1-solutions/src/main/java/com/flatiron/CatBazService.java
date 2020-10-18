package com.flatiron;

public class CatBazService {
	
	private FizzBuzzable fizzBuzzable;
	
	public CatBazService(FizzBuzzable fizzBuzzable) {
		this.fizzBuzzable = fizzBuzzable;
	}
	
	/**
	 * Sends an int to fizzbuzz for processing. If fizzbuzz returns "Fizz" or "Buzz",
	 * return that value, otherwise return "Baz" if the number is even and "Cat" if the
	 * number is odd.
	 * @param i
	 * @return "Baz" if fizzbuzz returns an even number, "Cat" if it returns an odd number, 
	 * 			or else the Fizzbuzz string.
	 */
	public String catBaz(int i) {
		String fb = fizzBuzzable.fizzBuzz(i).getOutput();
		switch(fb) {
		case "Fizz", "Buzz", "FizzBuzz" -> {return fb;}
		default -> {return catBaz(fb);}
		}
	}
	
	private String catBaz(String i) {
		try {
			if( Integer.parseInt(i) % 2 == 0) {
				return "Baz";
			} else {
				return "Cat";
			}
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException("FizzBuzz returned the string " + i + " which cannot be parsed by CatBaz" );
		}
	}
}
