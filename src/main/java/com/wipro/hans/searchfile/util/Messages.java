package com.wipro.hans.searchfile.util;

import java.util.HashMap;
import java.util.Map;

public class Messages {

	/**
	 * hide implicit public constructor
	 */
	private Messages() {

	}

	private static final Map<String, String> MESSAGE_MAP;
	static {
		MESSAGE_MAP = new HashMap<String, String>();
		MESSAGE_MAP.put("E0001",
				"Input invalid, supply an input param 'directory' with a valid directory namee and a'searchValue' with one or more words to search for");
		MESSAGE_MAP.put("E0002", "The given directory does not exist or is not a directory");
		MESSAGE_MAP.put("E0003", "File was not found");
		MESSAGE_MAP.put("E0004", "Invalid searchValue, supply a 'searchValue' with one or more words to search for");
		MESSAGE_MAP.put("E0005", "Invalid directory, supply a'directory' with a valid directory name");
		MESSAGE_MAP.put("E0006",
				"The start directory for searching is not defined. Contact SearchService administrator\"");
		MESSAGE_MAP.put("E0007", "Unable to to read application properties. Conact SearchService administrator");

		MESSAGE_MAP.put("E9001", "Unexpected error, contact SearchService administator");

		MESSAGE_MAP.put("I0001", "Nothing found for this request");
	}

	/**
	 * Returns a message for the given code
	 * 
	 * @param code
	 * @return message of null if nothing found for code
	 */
	public static String getMessageDescription(String code) {
		return MESSAGE_MAP.get(code);
	}

}
