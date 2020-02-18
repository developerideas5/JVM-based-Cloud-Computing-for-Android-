package com.android.paas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.paas.util.ConnectionHelper;
import com.android.paas.util.XMLHelper;

import android.os.AsyncTask;


public class CopyOfCalculatorOnCloud {

	List<String> result = null;

	 
	public List<String> sin(Double value) {
		
		
		new AsyncTask<Double, Integer, List<String>>() {

			protected void onPostExecute(List<String> result1) {
				
				System.out.println("CalculatorOnCloud.sin(...).new AsyncTask() {...}.onPostExecute()");
				
				result = result1;
				
				Thread.currentThread().interrupt();
				
				System.out.println("Result found is: " + result1);
				
			};
			
			@Override
			protected List<String> doInBackground(Double... params) {
				
				Map<String , String> inputValues = new HashMap<String, String>();
				
				inputValues.put("firstValue", params[0].toString());
				
				ConnectionHelper helper = new ConnectionHelper();
				
				String xml = helper.callCloud("sin", inputValues);
				
				System.out.println("XML received: " + xml); 
				
				XMLHelper xmlHelper = new XMLHelper();
				
				List<String> finalAns = xmlHelper.getData(xml, "sinAns");
				
				System.out.println("CalculatorOnCloud.sin()");
				
				System.out.println("In Async task: Returning Answer");
				
				return finalAns;
			}
			
		}.execute(value);
		
		
	// (result == null);
			
		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			System.out.println("Thread awake. Got Answer");
		}
		
		
		System.out.println("After Async Task");
		
		return result;
	}
	
	
	
	
	
	
}
