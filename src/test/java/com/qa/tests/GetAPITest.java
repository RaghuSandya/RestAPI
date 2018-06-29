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
import com.qa.utils.TestUtil;

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

	@Test(priority=1)
	public void getAPITestwithoutHeader() throws ClientProtocolException, IOException {
		// Object of ResTClient
		restclient = new RestClient();
		closeblehttpResponce=restclient.get(url);
		
		// a.status code
					int Statuscode = closeblehttpResponce.getStatusLine().getStatusCode();
					System.out.println("Responce code is:" + Statuscode);
					
					Assert.assertEquals(Statuscode,Responce_Status_Code_200);

					// to Get JSON String
					String responce = EntityUtils.toString (closeblehttpResponce.getEntity(),"UTF-8");
					JSONObject responcejson = new JSONObject(responce);
					System.out.println("Json resonce is--->" + responcejson);
					
					//Single value
					//Total per page
					String perpageValue=TestUtil.getValueByJPath(responcejson,"/per_page");
					System.out.println("PerPage Value is--->"+perpageValue);
					Assert.assertEquals(Integer.parseInt(perpageValue),3);
					
					//Total pages 
					String total=TestUtil.getValueByJPath(responcejson,"/total");
					System.out.println("total is--->"+total);
					Assert.assertEquals(Integer.parseInt(total),12);
					
					
					//to get the value SON Array
					String id=TestUtil.getValueByJPath(responcejson, "/data[1]/id");
					/*String name=TestUtil.getValueByJPath(responcejson, "/data[]/name");
					String year=TestUtil.getValueByJPath(responcejson, "/data[1]/year");
					String pantonvalue=TestUtil.getValueByJPath(responcejson, "/data[1]/pantone_value");
					*/
					System.out.println("The id of person is--->"+id);
					/*System.out.println(name);
					System.out.println(year);
					System.out.println(pantonvalue);
					*/
					// c.to GET Header
					Header[] headerArray = closeblehttpResponce.getAllHeaders();
					// HashMap for Get key and value
					HashMap<String, String> allheaders = new HashMap<String, String>();
					for (Header header : headerArray) {
						allheaders.put(header.getName(), header.getValue());
					}
					System.out.println("header array is----->" + allheaders);
				}
	
	
	@Test(priority=2)
	public void getAPITestwithHeader() throws ClientProtocolException, IOException {
		// Object of ResTClient
		restclient = new RestClient();
		
		HashMap<String,String>headermap=new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");
		headermap.put("username", "test@amezon.com");
		headermap.put("password", "test123");
		
		closeblehttpResponce=restclient.get(url,headermap);
		
		// a.status code
					int Statuscode = closeblehttpResponce.getStatusLine().getStatusCode();
					System.out.println("Responce code is:" + Statuscode);
					
					Assert.assertEquals(Statuscode,Responce_Status_Code_200);

					// to Get JSON String
					String responce = EntityUtils.toString (closeblehttpResponce.getEntity(),"UTF-8");
					JSONObject responcejson = new JSONObject(responce);
					System.out.println("Json resonce is--->" + responcejson);
					
					//Single value
					//Total per page
					String perpageValue=TestUtil.getValueByJPath(responcejson,"/per_page");
					System.out.println("PerPage Value is--->"+perpageValue);
					Assert.assertEquals(Integer.parseInt(perpageValue),3);
					
					//Total pages 
					String total=TestUtil.getValueByJPath(responcejson,"/total");
					System.out.println("total is--->"+total);
					Assert.assertEquals(Integer.parseInt(total),12);
					
					
					//to get the value SON Array
					String id=TestUtil.getValueByJPath(responcejson, "/data[2]/id");
					/*String name=TestUtil.getValueByJPath(responcejson, "/data[]/name");
					String year=TestUtil.getValueByJPath(responcejson, "/data[1]/year");
					String pantonvalue=TestUtil.getValueByJPath(responcejson, "/data[1]/pantone_value");
					*/
					System.out.println("The id of the person is--->"+id);
					/*System.out.println(name);
					System.out.println(year);
					System.out.println(pantonvalue);
					*/
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


