package com.wipro.hans.searchfile.util;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class TestHelper {

	@Test
	public void splitInput() {

		String input = "convert the input into,an,aaray";
		String[] inputArray = Helper.searchStringToArray(input);

		System.out.println("array: " + Arrays.toString(inputArray));
		assertEquals(6, inputArray.length);

		assertEquals("into", inputArray[3]);
	};
}
