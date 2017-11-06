package com.wipro.hans.searchfile.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wipro.hans.searchfile.controller.SearchController;
import com.wipro.hans.searchfile.model.Result;
import com.wipro.hans.searchfile.util.Messages;

@RunWith(SpringJUnit4ClassRunner.class)
// @SpringBootTest(classes = TestContextConfiguration.class)
@SpringBootTest
@ContextConfiguration
public class TestSearchController {

	@Value("${searchDirectory}")
	private String searchDirectory;

	@Test
	public void fileFound() {

		SearchController searchController = new SearchController();

		Result result = searchController.search("son&breugel");

		if (result.getFiles() != null && result.getFiles().get(0) != null) {
			assertEquals("SonAndBreugel.txt", result.getFiles().get(0).getName());
		} else {
			// force failure
			assertNotNull(result.getFiles());
			assertNotNull(result.getFiles().get(0));
		}
	}

	@Test
	public void validRequestButNoFilesFound() {

		SearchController searchSevice = new SearchController();

		Result result = searchSevice.search("nonexisting_word");

		assertNull(result.getFiles());

		assertEquals("I0001", result.getMessage().getCode());

	}

	@Test
	public void propertySearchDirectoryExists() {

		assertNotNull(searchDirectory);
		assertNotEquals(0, searchDirectory.length());

	}

	@Test
	public void searchValueIsvalid() {

		String searchValue = null;
		SearchController searchController = new SearchController();

		// test searchValue is null
		Result result = searchController.search(null);
		assertEquals(Messages.getMessageDescription("E0004"), result.getMessage().getDescription());

		// test searchValue contains empty string
		searchValue = "";
		result = searchController.search(searchValue);
		assertEquals(Messages.getMessageDescription("E0004"), result.getMessage().getDescription());

	}

}