package com.flatiron;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FizzBuzzTest {
	
	@Mock
	FizzBuzzService fbsMock;
	
	@Test
	public void alwaysBuzzService_alwaysBuzzes() {
		AlwaysBuzzService abs = new AlwaysBuzzService();
		for(int i = 1; i <= 100; i++) {
			assertEquals("Buzz", abs.fizzBuzz(i).getOutput());
		}
	}
	
	@RepeatedTest(100)
	public void alwaysBuzzService_alwaysBuzzes_repeated(RepetitionInfo info) {
		AlwaysBuzzService abs = new AlwaysBuzzService();
		assertEquals("Buzz", abs.fizzBuzz(info.getCurrentRepetition()).getOutput());
	}
	
	@ParameterizedTest
	@CsvSource({
		"3, Fizz", 
		"5, Buzz", 
		"15, FizzBuzz", 
		"1, 1", 
		"97, 97"} )
	public void fizzBuzzService_standardInputs_happyPath(int i, String response) {
		FizzBuzzService fbs = new FizzBuzzService(new FBConfig(3,5));
		assertEquals(response, fbs.fizzBuzz(i).getOutput());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Fizz", "Buzz", "FizzBuzz"})
	public void catBazService_forwardFizzBuzzString(String output) {
		when(fbsMock.fizzBuzz(anyInt())).thenReturn(new FBResult(output, 1));
		CatBazService cbs = new CatBazService(fbsMock);
		assertEquals(output, cbs.catBaz(1));
	}
	
	@ParameterizedTest
	@CsvSource({
		"1, Cat", 
		"2, Baz", 
		"15, Cat", 
		"8, Baz", 
		"97, Cat"} )
	public void catBazService_standardInputs_happyPath(int i, String output) {
		when(fbsMock.fizzBuzz(anyInt())).thenReturn(new FBResult(Integer.toString(i), 1));
		CatBazService cbs = new CatBazService(fbsMock);
		assertEquals(output, cbs.catBaz(1));
	}
	
	@Test
	public void catBazService_throwsIllegalArgumentException_invalidInput() {
		when(fbsMock.fizzBuzz(anyInt())).thenReturn(new FBResult("Ooops", 1));
		CatBazService cbs = new CatBazService(fbsMock);
		assertThrows(IllegalArgumentException.class, () -> cbs.catBaz(1));
	}

}
