package com.wipro.hans.searchfile.controller;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.hans.searchfile.dao.SearchDao;
import com.wipro.hans.searchfile.dao.SearchDaoImpl;
import com.wipro.hans.searchfile.model.Result;
import com.wipro.hans.searchfile.model.ResultMessage;
import com.wipro.hans.searchfile.transformation.FilesToResult;
import com.wipro.hans.searchfile.util.Messages;

/**
 * This class handles all incoming rest request where the request starts with
 * 'search'
 * 
 * @author HA256157
 *
 */
@RestController
@RequestMapping("/search")
public class SearchController {

	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	// inject searchDirectory
	@Value("${searchDirectory}")
	private String searchDirectory;

	/**
	 * Search the file system starting from the given directory and returns the
	 * absolute filenames for all the files which contain the given words
	 * (searchValue)
	 * 
	 * @param directory
	 * @param searchValue
	 * @return
	 */
	@GetMapping
	public Result search(@RequestParam(required = false) String searchValue) {

		logger.debug("\n\nIn search(String searchValue(): " + searchValue);

		Result result = new Result();
		try {

			// validate input parameters
			isValidSearchValue(searchValue);

			// split input into separate words
			String[] searchArray = searchStringToArray(searchValue);

			// Get the files
			SearchDao searchDao = new SearchDaoImpl();
			List<File> files = searchDao.getFilesContainingWords(searchDirectory, searchArray);

			if (files != null && !files.isEmpty()) {
				result = FilesToResult.transform(files);
			} else {
				// nothing found
				String code = "I0001";
				result.setMessage(new ResultMessage(code, Messages.getMessageDescription(code)));
			}

		} catch (SearchFileException sse) {
			result.setMessage(new ResultMessage(sse.getCode(), Messages.getMessageDescription(sse.getCode())));
			logger.error("SearchFileException: " + result.getMessage().toString());

		} catch (Exception e) {

			// this should never happen!!
			String msgCode = "E9001";
			result.setMessage(new ResultMessage(msgCode, Messages.getMessageDescription(msgCode)));
			logger.error("Exception", result.getMessage().toString(), e);
		}

		return result;
	}

	/**
	 * Spilt param into string array. Seperate on whitespace and comma
	 * 
	 * @param searchString
	 * @return array of strings
	 */
	private static String[] searchStringToArray(String searchString) {

		return searchString.split(",|\\s+");

	}

	/**
	 * Check if the input parameter searchValue contains a valid value
	 * 
	 * @param searchValue
	 * @return boolean
	 * @throws SearchFileException
	 */
	private static boolean isValidSearchValue(String searchValue) throws SearchFileException {

		if (searchValue == null || searchValue.length() == 0) {
			throw new SearchFileException("E0004");
		}

		//
		// add additional validation if necesarry
		//

		return true;
	}

}
