package com.wipro.hans.searchfile.model;

import java.util.ArrayList;
import java.util.List;

/**
 * this class holds the result. It contains the files found (path and name) or
 * an error or info message
 * 
 * The result is parsed into the response as an XML message
 * 
 * @author ha256157
 *
 */
// @XmlRootElement(name = "Result")
// @XmlAccessorType(XmlAccessType.FIELD)
public class Result {

	private ResultMessage message;

	// @XmlElement(name = "File")
	private List<ResultFile> files;

	public void addFile(ResultFile file) {
		if (files == null) {
			files = new ArrayList<ResultFile>();
		}
		files.add(file);
	}

	public ResultMessage getMessage() {
		return message;
	}

	public void setMessage(ResultMessage message) {
		this.message = message;
	}

	public List<ResultFile> getFiles() {
		return files;
	}

	public void setFiles(List<ResultFile> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "Result [message=" + message + ", files=" + files + "]";
	}
}
