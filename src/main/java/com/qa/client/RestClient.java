package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
		// 1.GET Method
		public void get(String url) throws ClientProtocolException, IOException {
			
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(url);// Http get Request
			CloseableHttpResponse closeblehttpResponce = httpclient.execute(httpget);// hit GET URL
			
			// a.status code
			int Statuscode = closeblehttpResponce.getStatusLine().getStatusCode();
			System.out.println("Responce code is:" + Statuscode);

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



