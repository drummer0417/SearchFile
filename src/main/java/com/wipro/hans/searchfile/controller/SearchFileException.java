package com.wipro.hans.searchfile.controller;

/**
 * Class to for handleing SearchFile application errors
 * 
 * @author ha256157
 *
 */
public class SearchFileException extends Exception {

	private static final long serialVersionUID = 5469183001601319916L;
	private final String code;

	/**
	 * Contructor takes the SearchFile error code
	 * 
	 * @return
	 */
	public SearchFileException(String code) {
		this.code = code;
	}

	/**
	 * Contructor takes a throwabe (cause) the SearchFile error code
	 * 
	 * @return
	 */
	public SearchFileException(String code, Throwable t) {

		super(t);
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
