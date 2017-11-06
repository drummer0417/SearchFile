package com.wipro.hans.searchfile.transformation;

import java.io.File;
import java.util.List;

import com.wipro.hans.searchfile.model.Result;
import com.wipro.hans.searchfile.model.ResultFile;

/**
 * Transform a List of java.io.File's to a Result which contains a list of
 * ResultFile's or an error or info message
 * 
 * @author HA256157
 *
 */
public class FilesToResult {

	/**
	 * hide implicit public constructor
	 */
	private FilesToResult() {

	}

	/**
	 * Transform the given list of files into a Result which contains a list of
	 * ResultFiles
	 * 
	 * @param files
	 * @return Result
	 */
	public static Result transform(List<File> files) {

		Result result = new Result();

		for (File file : files) {
			result.addFile(new ResultFile(file.getParent(), file.getName()));
		}
		return result;
	}
}
