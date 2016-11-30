package com.user.model;

public class LoginBean {
	private boolean result;
	private String id;
	
	public LoginBean() {
		result=false;
		id="guest";
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LoginBean [result=" + result + ", id=" + id + "]";
	}
	
}
