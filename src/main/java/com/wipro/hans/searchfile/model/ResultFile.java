package com.wipro.hans.searchfile.model;

public class ResultFile {

	private String name;

	private String path;

	public ResultFile() {
	}

	public ResultFile(String path, String name) {
		this.name = name;
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ResultFile [name=" + name + ", path=" + path + "]";
	}

}
