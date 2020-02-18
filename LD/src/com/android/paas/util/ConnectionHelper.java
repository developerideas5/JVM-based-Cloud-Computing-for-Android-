package com.android.paas.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.os.StrictMode;

public class ConnectionHelper {

	public String callCloud(String functionName,
			Map<String, String> keyValuePair) {

		
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
		
		HttpClient c = new DefaultHttpClient();

		String result = "";

		StringBuilder out = new StringBuilder();

		String url = "http://paas4a.cloudfoundry.com/AppsStore/" + functionName
				+ ".htm?";

		for (String key : keyValuePair.keySet()) {

			url += key + "=" + keyValuePair.get(key) + "&";
		}
		
		System.out.println("Calling cloud at: " + url);

		try {

			HttpResponse hr = c.execute(new HttpGet(url));

			BufferedReader br = new BufferedReader(new InputStreamReader(hr
					.getEntity().getContent()));

			String var = "";
			while (var != null) {
				out.append(var);
				var = br.readLine();
			}

		} catch (ClientProtocolException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return out.toString();
	}

	public List<String> callCloudWithParser(String functionName, Map<String, String> keyValuePair, String outputTagName) {

		HttpClient c = new DefaultHttpClient();

		List<String> returnResult = new ArrayList<String>();
		
		String url = "http://paas4a.cloudfoundry.com/AppsStore/" + functionName
				+ ".htm?";

		for (String key : keyValuePair.keySet()) {

			url += key + "=" + keyValuePair.get(key) + "&";
		}
		
		
		System.out.println("Calling cloud at: " + url);

		Document dom = null;
		   
	     try {
	     	
	    	 
	    	 
	    	 
	     	dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url);	        	

				
			    
				//System.out.println("************ "+dom.getElementsByTagName("value").item(0).getChildNodes().item(0).getNodeValue());
			       			       
		      Element root = dom.getDocumentElement();
		        	 
				   
		      NodeList rootTag = dom.getElementsByTagName(outputTagName);
		        	 
		      for (int i = 0; i < rootTag.getLength(); i++) {
				
		    	  returnResult.add(rootTag.item(0).getChildNodes().item(0).getNodeValue());
			}   	 
		        	 
	     }
	     catch (Exception e) {
			
	     e.printStackTrace();
	     
	     }
		return returnResult;
	}

	
	
	
	
	
	
	
	 
	
}
