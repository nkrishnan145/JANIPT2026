package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertClass {
	
	@Test
	
	private void testMethod() {
	    String actual = "Naveen";
	    String expected = "Naveen"; 
	    Assert.assertEquals(actual, expected);
	    System.out.println("VALIDATION DONE");
	}

}
