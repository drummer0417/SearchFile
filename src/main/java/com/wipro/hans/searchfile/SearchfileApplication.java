package com.wipro.hans.searchfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchfileApplication {

	private static final Logger logger = LoggerFactory.getLogger(SearchfileApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SearchfileApplication.class, args);

		logger.info("***** The searchfile app is started *****");
	}
}
