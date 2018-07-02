package com.qa.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
		// 1.GET Method without header
		public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
			
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(url);// Http get Request
			CloseableHttpResponse closeblehttpResponce = httpclient.execute(httpget);// hit GET URL
			return closeblehttpResponce;
		}	
		
		// 2.GET Method with header
				public CloseableHttpResponse get(String url,HashMap<String,String>headerMap) throws ClientProtocolException, IOException {
					CloseableHttpClient httpclient = HttpClients.createDefault();
					HttpGet httpget = new HttpGet(url);// Http get Request
					
					for(Map.Entry<String,String> entry:headerMap.entrySet()){
						httpget.addHeader(entry.getValue(),entry.getKey());
					}
					
					CloseableHttpResponse closeblehttpResponce = httpclient.execute(httpget);// hit GET URL
					return closeblehttpResponce;
				}
				
				//3.POST Method
				public CloseableHttpResponse post(String url,String entitystring,HashMap<String,String> headerMap) throws ClientProtocolException, IOException{
					CloseableHttpClient httpclient = HttpClients.createDefault();
					HttpPost httppost = new HttpPost(url);// Http Post Request
					httppost.setEntity(new StringEntity(entitystring));//for pay load
					
					//for header
					for(Map.Entry<String,String> entry:headerMap.entrySet()){
						httppost.addHeader(entry.getValue(),entry.getKey());
					}
					
					CloseableHttpResponse closeblehttpResponce=httpclient.execute(httppost);
					return closeblehttpResponce;
				}
				


	}



