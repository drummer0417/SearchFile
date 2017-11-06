package com.wipro.hans.searchfile.util;

public class Helper {

	/**
	 * hide implicit public constructor
	 */
	private Helper() {
	}

	/**
	 * Spilt param into string array. Seperate on whitespace and comma
	 * 
	 * @param searchString
	 * @return array of strings
	 */

	public static String[] searchStringToArray(String searchString) {

		return searchString.split(",|\\s+");

	}

}
