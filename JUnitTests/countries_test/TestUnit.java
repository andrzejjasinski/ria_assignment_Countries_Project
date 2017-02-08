package com.ait.countries_test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestUnit 
{
	String message = "Hello Andrzej";
			
	ClassToBeTested = new ClassToBeTested(message);
	@Test
	public void testPrintMessage()
	{
		assertEquals(message,ClassToBeTested.printMessage());
	}
}
