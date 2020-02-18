package com.jvm.cloud;

public class CalcBean {

	private String firstValue;
	private String secondValue;
	public String getFirstValue() {
		return firstValue;
	}
	public void setFirstValue(String firstValue) {
		this.firstValue = firstValue;
	}
	public String getSecondValue() {
		return secondValue;
	}
	public void setSecondValue(String secondValue) {
		this.secondValue = secondValue;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CalcBean [firstValue=");
		builder.append(firstValue);
		builder.append(", secondValue=");
		builder.append(secondValue);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
