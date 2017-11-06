package com.wipro.hans.searchfile.dao;

import java.io.File;
import java.util.List;

import com.wipro.hans.searchfile.controller.SearchFileException;

public interface SearchDao {

	/**
	 * 
	 * Search the file system starting from the given directory and returns a list
	 * with the absolute filenames for all the files which contain the given words
	 * 
	 * @param directory
	 * @param words
	 * @return List <Files>
	 * @throws SearchFileException
	 * 
	 */
	public List<File> getFilesContainingWords(String directory, String[] words) throws SearchFileException;

}
