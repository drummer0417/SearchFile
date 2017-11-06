package com.wipro.hans.searchfile.util;

/**
 * This is a singleton class which holds all the properties for the searchfile
 * application Properties are read from the application classpath
 * 
 * @author ha256157
 *
 */
public class SearchFileProperties {

	// private static final String SEARCHFILE_PROPERTIES_FILE =
	// "applications.properties";
	//
	// private Properties properties;
	//
	// private static SearchFileProperties instance = null;
	//
	// private SearchFileProperties() {
	//
	// }
	//
	// /**
	// * Returns an instance (singleton) of the this class
	// *
	// * @return
	// * @throws SearchFileException
	// */
	// public static SearchFileProperties getInstance() throws SearchFileException {
	// if (instance == null) {
	//
	// instance = new SearchFileProperties();
	// instance.initProperties();
	// }
	// return instance;
	// }
	//
	// /**
	// * Search the properties file for the given property (key) and return the
	// * associated value
	// *
	// * @param property
	// * @return the value found or null if nothing found
	// * @throws SearchFileException
	// */
	// public String getProperty(String property) {
	//
	// return properties.getProperty(property);
	// }
	//
	// private void initProperties() throws SearchFileException {
	//
	// properties = new Properties();
	//
	// try {
	// InputStream is =
	// getClass().getClassLoader().getResourceAsStream(SEARCHFILE_PROPERTIES_FILE);
	// properties.load(is);
	//
	// } catch (IOException e) {
	// throw new SearchFileException("E0007");
	// }
	// }
}
