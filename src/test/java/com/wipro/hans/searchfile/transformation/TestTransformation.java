package com.wipro.hans.searchfile.transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.wipro.hans.searchfile.model.Result;
import com.wipro.hans.searchfile.model.ResultMessage;

public class TestTransformation {

	@Test
	public void transformFilesNotEmpty() {

		List<File> files = new ArrayList<File>();
		String expect = "Result [message=null, files=[ResultFile [name=fileOne.txt, path=D:\\the\\file\\path], ResultFile [name=fileTwo.txt, path=D:\\another\\file\\path]]]";

		files.add(new File("D:/the/file/path", "fileOne.txt"));
		files.add(new File("D:/another/file/path", "fileTwo.txt"));

		Result result = new Result();

		result = FilesToResult.transform(files);
		assertEquals(expect, result.toString());
		assertNull(result.getMessage());
	}

	@Test
	public void transformMessageNotEmpty() {

		List<File> files = new ArrayList<File>();
		String expect = "Result [message=ResultMessage [code=xxxx, description=This is a test message], files=null]";

		files.add(new File("/the/file/path", "fileOne.txt"));
		files.add(new File("/another/file/path", "fileTwo.txt"));

		Result result = new Result();

		result.setMessage(new ResultMessage("xxxx", "This is a test message"));
		assertEquals(expect, result.toString());
		assertNull(result.getFiles());
	}
}
