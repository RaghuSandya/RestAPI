package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetAPITest extends TestBase {

	TestBase test;
	String serviceurl;
	String apiurl;
	String url;
	RestClient restclient;

	@BeforeMethod
	public void setup() {

		test = new TestBase();
		serviceurl = prop.getProperty("URL");
		apiurl = prop.getProperty("service");

		// https://reqres.in/api/user

		url = serviceurl + apiurl;

	}

	@Test
	public void getAPITest() throws ClientProtocolException, IOException {
		// Object of ResTClient
		restclient = new RestClient();
		restclient.get(url);

	}

}
