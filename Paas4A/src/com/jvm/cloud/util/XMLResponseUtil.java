package com.jvm.cloud.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLResponseUtil {

	public void writeXMLResponse(List<String> ans, String ansNode) {
		
		File f = new File("webapps/ROOT/Apps.xml");
    	
    	try {
		
    		f.createNewFile();
			
    		FileWriter ff = new FileWriter(f);
			
    		StringBuilder responseString = new StringBuilder("<data>");
    		
    		for (String currentAns : ans) {
				
    			responseString.append("<").append(ansNode).append(">");
				responseString.append(currentAns);
				responseString.append("</").append(ansNode).append(">");
			}
    		
    		
    		responseString.append("</data>");
    		
    		ff.write(responseString.toString());
			
    		ff.close();
		
			System.out.println("File Written Successfully");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
