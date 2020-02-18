package com.cloud.algo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.paas.util.ConnectionHelper;
import com.android.paas.util.XMLHelper;

public class LdOnCloud {

	public List<String> LD(String value,String value1) {
			
	Map<String , String> inputValues = new HashMap<String, String>();
		
		inputValues.put("firstValue", value);
		inputValues.put("secondValue", value1);
		
		List<String> finalAns = connectToNet(inputValues,"LD", "LDAns");
		
		return finalAns;
	}

	private List<String> connectToNet(Map<String, String> inputValues, String functionName, String nodeName) {
		ConnectionHelper helper = new ConnectionHelper();
		
		String xml = helper.callCloud(functionName , inputValues);
		
		System.out.println("XML received: " + xml); 
		
		XMLHelper xmlHelper = new XMLHelper();
		
		List<String> finalAns = xmlHelper.getData(xml, nodeName);
		
		System.out.println("Returning Answer");
		return finalAns;
	}


}
