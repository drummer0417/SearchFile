package com.wipro.hans.searchfile.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wipro.hans.searchfile.controller.SearchFileException;
import com.wipro.hans.searchfile.util.FileScanner;

public class SearchDaoImpl implements SearchDao {

	private static final Logger logger = LoggerFactory.getLogger(SearchDaoImpl.class);

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
	public List<File> getFilesContainingWords(String directory, String[] words) throws SearchFileException {

		String pattern = createPattern(words);

		return examineFiles(new File(directory), pattern, null);
	}

	/**
	 * Examine the given Directory. If the a file in the directory is a directory
	 * --> recursively call this method. if the file is not a directory --> scan the
	 * file for the given words. If the file contains all the given words, it's a
	 * match and the file will be added to the result
	 * 
	 * @param file
	 * @param pattern
	 * @param result
	 * @return
	 * @throws SearchFileException
	 */
	private List<File> examineFiles(File file, String pattern, List<File> result) throws SearchFileException {

		if (!file.isDirectory()) {

			throw new SearchFileException("E0002");
		}

		if (result == null) {
			result = new ArrayList<File>();
		}

		File[] files = file.listFiles();

		if (files != null) {

			for (File currentFile : files) {

				// check filetype. if directory than call examineFiles(....)
				if (currentFile.isDirectory()) {
					examineFiles(currentFile, pattern, result);
				} else {
					FileScanner fs = new FileScanner();
					if (fs.fileContainsPattern(currentFile, pattern)) {
						logger.debug("document found: " + currentFile.getName());
						result.add(currentFile);
					}
				}
			}
		}
		return result;
	}

	/**
	 * Convert the array of words into a pattern which will match, if all words are
	 * found in the object the pattern is applied to
	 * 
	 * sample pattern to match word1 and word2:
	 * (?=.*(?i)\bword1\b.*?)(?=.*\bword2\b.*?); <br>
	 * <br>
	 * sample pattern to match word1 or word2: <br>
	 * (.*?(?i)\bword1|word2\b.*?)";
	 * 
	 * (?i) - ignorecase <br>
	 * .*? - allow (optinally) any characters before <br>
	 * \b - word boundary word matches [a-zA-Z0-9_]. <br>
	 * %s - variable to be changed by String.format (quoted to avoid regex
	 * errors)<br>
	 * \b - word boundary<br>
	 * .*? - allow (optinally) any characters after
	 *
	 * @param words
	 * @return
	 */
	private String createPattern(String[] words) {

		StringBuilder pattern = new StringBuilder();

		// String patternBegin = "(.*?(?i)\\b";
		// String patternEnd = "\\b.*?)";

		String patternBegin = "(?=.*(?i)\\b";
		String patternEnd = "\\b.*?)";

		for (String word : words) {
			pattern.append(patternBegin);
			pattern.append(word);
			pattern.append(patternEnd);
		}

		// for (int i = 0; i < words.length; i++) {
		// wordsToMatch.append(words[i]);
		// // check if there are more words in array
		// if (i < words.length - 1) {
		// wordsToMatch.append("|");
		// }
		// }

		// now assemble the pattern

		// pattern = patternBegin + wordsToMatch + patternEnd;

		// System.out.println("pattern: " + pattern);

		return pattern.toString();
	}
}
