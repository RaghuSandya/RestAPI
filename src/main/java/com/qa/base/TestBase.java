package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fin = new FileInputStream(System.getProperty(
					"E:/GC Reddy Sql/CUMCUMBER/API Testing/WorkSpace/src/main/java/com/qa/config/config.properties"));
			prop.load(fin);
		} catch (IOException e) {
			e.getMessage();
		}
	}

}
