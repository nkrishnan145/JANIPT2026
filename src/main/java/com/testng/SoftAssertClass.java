package com.testng;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertClass {

	@Test

	private void testMethod() {
		String actual = "Naveen";
		String expected = "Naveen145"; 
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actual, expected);
		System.out.println("VALIDATION DONE");
	}

}
