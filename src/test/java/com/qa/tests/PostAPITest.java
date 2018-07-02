package com.qa.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Users;

public class PostAPITest extends TestBase{
	

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
	public void postapiTest() throws JsonGenerationException, JsonMappingException, IOException{
		restclient= new RestClient();
		//closeblehttpResponce=restclient.get(url);
		
		HashMap<String,String>headermap=new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");
		
		//Jackson API;
		
		ObjectMapper mapper=new ObjectMapper();
		Users user =new Users("Giddu","Test");//Expected user object
		
		//object json
		mapper.writeValue(new File("E:/GC Reddy Sql/CUMCUMBER/API Testing/WorkSpace/src/main/java/com/qa/data/user.json"), user);
		
		//Object to jsonString
		String userJsonString=mapper.writeValueAsString(user);
		System.out.println(userJsonString);
		
		closeblehttpResponce=restclient.post(url, userJsonString, headermap);//hit the API
		
		//Validate the response from API
		//1.Status code
		
		int Statuscode=closeblehttpResponce.getStatusLine().getStatusCode();
		Assert.assertEquals(Statuscode, test.Responce_Status_Code_200);
		
		//JsonString
		
		String responcestring=EntityUtils.toString(closeblehttpResponce.getEntity(), "UFT-8");
		
		JSONObject respjson=new JSONObject(responcestring);
		System.out.println("The responce form API is --->:"+respjson);
		
		//JSON to JAVA Object
		Users useresponce=mapper.readValue(responcestring, Users.class);//Actual user object
		System.out.println(useresponce);
		
		Assert.assertTrue(user.getName().equals(useresponce.getName()));
		Assert.assertTrue(user.getJob().equals(useresponce.getJob()));
		
		System.out.println(useresponce.getCreatAt());
		System.out.println(useresponce.getId());
		
		 
	}


	

}
