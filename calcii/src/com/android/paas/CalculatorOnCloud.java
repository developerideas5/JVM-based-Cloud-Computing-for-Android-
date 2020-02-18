package com.android.paas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;

import com.android.paas.util.ConnectionHelper;
import com.android.paas.util.XMLHelper;

public class CalculatorOnCloud {

	List<String> result = null;
	

	public List<String> plus(Float value,Float value1) {
			
	Map<String , String> inputValues = new HashMap<String, String>();
		
		inputValues.put("firstValue", value.toString());
		inputValues.put("secondValue", value1.toString());
		
		List<String> finalAns = connectToNet(inputValues,"plus", "plusAns");
		
		return finalAns;
	}



	public List<String> minus(Float value,Float value1) {
			
	Map<String , String> inputValues = new HashMap<String, String>();
		
		inputValues.put("firstValue", value.toString());
		inputValues.put("secondValue", value1.toString());
		
		List<String> finalAns = connectToNet(inputValues,"minus", "minusAns");
		
		return finalAns;
	}



	public List<String> multiply(Float value,Float value1) {
			
	Map<String , String> inputValues = new HashMap<String, String>();
		
		inputValues.put("firstValue", value.toString());
		inputValues.put("secondValue", value1.toString());
		
		List<String> finalAns = connectToNet(inputValues,"multiply", "multiplyAns");
		
		return finalAns;
	}


	public List<String> divide(Float value,Float value1) {
			
	Map<String , String> inputValues = new HashMap<String, String>();
		
		inputValues.put("firstValue", value.toString());
		inputValues.put("secondValue", value1.toString());
		
		List<String> finalAns = connectToNet(inputValues,"divide", "divideAns");
		
		return finalAns;
	}
	 
	public List<String> dec(String value) {
			
	Map<String , String> inputValues = new HashMap<String, String>();
		
		inputValues.put("firstValue", value.toString());
		//inputValues.put("firstValue", value.toString());
		
		List<String> finalAns = connectToNet(inputValues,"dec", "decAns");
		
		return finalAns;
	}


	 
	public List<String> bin(String value) {
			
	Map<String , String> inputValues = new HashMap<String, String>();
		
		inputValues.put("firstValue", value.toString());
		//inputValues.put("firstValue", value.toString());
		
		List<String> finalAns = connectToNet(inputValues,"bin", "binAns");
		
		return finalAns;
	}
	

	 
	public List<String> hex(String value) {
			
	Map<String , String> inputValues = new HashMap<String, String>();
		
		inputValues.put("firstValue", value.toString());
		//inputValues.put("firstValue", value.toString());
		
		List<String> finalAns = connectToNet(inputValues,"hex", "hexAns");
		
		return finalAns;
	}

	

	public List<String> oct(String value) {
			
	Map<String , String> inputValues = new HashMap<String, String>();
		
		inputValues.put("firstValue", value.toString());
		//inputValues.put("firstValue", value.toString());
		
		List<String> finalAns = connectToNet(inputValues,"oct", "octAns");
		
		return finalAns;
	}


	public List<String> sin(Double value) {
			
	Map<String , String> inputValues = new HashMap<String, String>();
		
		inputValues.put("firstValue", value.toString());
		//inputValues.put("firstValue", value.toString());
		
		List<String> finalAns = connectToNet(inputValues,"sin", "sinAns");
		
		return finalAns;
	}


	public List<String> cos(Double value) {
		
	Map<String , String> inputValues = new HashMap<String, String>();
		
		inputValues.put("firstValue", value.toString());
		//inputValues.put("firstValue", value.toString());
		
		List<String> finalAns = connectToNet(inputValues,"cos", "cosAns");
		
		return finalAns;
	}
	
	public List<String> tan(Double value) {
		
		Map<String , String> inputValues = new HashMap<String, String>();
			
			inputValues.put("firstValue", value.toString());
			//inputValues.put("firstValue", value.toString());
			
			List<String> finalAns = connectToNet(inputValues,"tan", "tanAns");
			
			return finalAns;
		}
		

	public List<String> square_2(Double value) {
		
		Map<String , String> inputValues = new HashMap<String, String>();
			
			inputValues.put("firstValue", value.toString());
			//inputValues.put("firstValue", value.toString());
			
			List<String> finalAns = connectToNet(inputValues,"square_2", "square_2Ans");
			
			return finalAns;
		}
	
public List<String> qube(Double value) {
		
		Map<String , String> inputValues = new HashMap<String, String>();
			
			inputValues.put("firstValue", value.toString());
			//inputValues.put("firstValue", value.toString());
			
			List<String> finalAns = connectToNet(inputValues,"qube", "qubeAns");
			
			return finalAns;
		}
public List<String> root(Double value) {
		
		Map<String , String> inputValues = new HashMap<String, String>();
			
			inputValues.put("firstValue", value.toString());
			//inputValues.put("firstValue", value.toString());
			
			List<String> finalAns = connectToNet(inputValues,"root", "rootAns");
			
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
