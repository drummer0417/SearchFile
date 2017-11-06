package com.wipro.hans.searchfile.model;

/**
 * This class holds the message which is returned as part of the response of the
 * SearchService
 * 
 * @author HA256157
 *
 */
public class ResultMessage {

	private String code;

	private String description;

	public ResultMessage() {
	}

	public ResultMessage(String code, String message) {
		this.code = code;
		this.description = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ResultMessage [code=" + code + ", description=" + description + "]";
	}

}
