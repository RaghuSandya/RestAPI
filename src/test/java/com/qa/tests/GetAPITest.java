package com.qa.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
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
	CloseableHttpResponse closeblehttpResponce;

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
		closeblehttpResponce=restclient.get(url);
		
		// a.status code
					int Statuscode = closeblehttpResponce.getStatusLine().getStatusCode();
					System.out.println("Responce code is:" + Statuscode);
					
					Assert.assertEquals(Responce_Status_Code_200,Statuscode);

					// to Get JSON String
					String responce = EntityUtils.toString(closeblehttpResponce.getEntity(),"UTF-8");
					JSONObject responcejson = new JSONObject(responce);
					System.out.println("Json resonce is--->" + responcejson);

					// c.to GET Header
					Header[] headerArray = closeblehttpResponce.getAllHeaders();
					// HashMap for Get key and value
					HashMap<String, String> allheaders = new HashMap<String, String>();
					for (Header header : headerArray) {
						allheaders.put(header.getName(), header.getValue());
					}
					System.out.println("header array is----->" + allheaders);
				}

	}


