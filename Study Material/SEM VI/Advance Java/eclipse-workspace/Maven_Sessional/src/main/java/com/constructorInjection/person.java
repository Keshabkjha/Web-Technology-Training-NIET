package com.constructorInjection;

public class person {
	private String pId;
	private String pName;
	public person(String pId, String pName) {
	
		this.pId = pId;
		this.pName = pName;
	}
	@Override
	public String toString() {
		 return this.pId+  "  :  "+this.pName;
	}
	
}