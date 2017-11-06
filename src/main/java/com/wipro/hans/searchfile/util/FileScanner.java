package com.wipro.hans.searchfile.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wipro.hans.searchfile.controller.SearchFileException;

public class FileScanner {

	private static Logger logger = LoggerFactory.getLogger(FileScanner.class);

	public boolean fileContainsPattern(File file, String pattern) throws SearchFileException {

		Scanner sc = null;

		try (BufferedReader br = new BufferedReader(new FileReader(file));) {

			String line = null;

			while ((line = br.readLine()) != null) {

				sc = new Scanner(line);
				if (sc.findWithinHorizon(pattern, 0) != null) {
					return true;
				}
			}

		} catch (IOException e) {

			// this cannot happen as the filename was retrieved milliseconds ago, but have
			// to Catch it anyway
			throw new SearchFileException("E0003");

		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		return false;
	}

	// public List<File> processFile(File file, String searchPattern) {
	//
	// logger.debug("Processing file: " + file.getAbsolutePath());
	// logger.debug("SearchPattern: " + searchPattern);
	//
	// final LargeTextFactory factory = LargeTextFactory.defaultFactory();
	//
	// final Path bigTextFile = Paths.get(file.getAbsolutePath());
	//
	// try (final LargeText largeText = factory.load(bigTextFile);) {
	// Pattern pattern = Pattern.compile(searchPattern, Pattern.MULTILINE);
	//
	// final Matcher m = pattern.matcher(largeText);
	//
	// while (m.find()) {
	//
	// logger.debug(String.valueOf(m.start()));
	// }
	// largeText.close();
	//
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return null;
	//
	// }
}
