package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
	public int Responce_Status_Code_200=200;
	public int Responce_Status_Code_500=500;
	public int Responce_Status_Code_400=400;
	public int Responce_Status_Code_201=201;
	public int Responce_Status_Code_401=401;
	

	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fin = new FileInputStream("E:/GC Reddy Sql/CUMCUMBER/API Testing/WorkSpace/src/main/java/com/qa/config/config.properties");
			prop.load(fin);
		} catch (IOException e) {
			e.getMessage();
		}
	}

}
