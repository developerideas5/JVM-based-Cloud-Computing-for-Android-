package com.android.paas.util;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLHelper {

	public List<String> getData(String xmlString, String node) {
		
		List<String> returnResult = new ArrayList<String>();
		System.out.println("XMLHelper.getData()");

		Document dom = null;
		   
	     try {
	     	
	    	 
	    	 
	    	 
	     	dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xmlString.getBytes()));	        	

				
			    
				//System.out.println("************ "+dom.getElementsByTagName("value").item(0).getChildNodes().item(0).getNodeValue());
			       			       
		      Element root = dom.getDocumentElement();
		        	 
				   
		      NodeList rootTag = dom.getElementsByTagName(node);
		        	 
		      System.out.println("Answer Tags found: " + rootTag.getLength());
		      
		      for (int i = 0; i < rootTag.getLength(); i++) {
				
		    	  returnResult.add(rootTag.item(0).getChildNodes().item(0).getNodeValue());
			}   	 
		        	 
	     }
	     catch (Exception e) {
			
	     e.printStackTrace();
	     
	     }
		
		System.out.println("Returning Ans:" + returnResult);
		return returnResult;
	}
	
}
