package com.adapter.sharewe.dto;

public class TMRequestVO {

	private String textid;
	private String email;
	private String rcode;

	public String getTextid() {
		return textid;
	}
	public void setTextid(String textid) {
		this.textid = textid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRcode() {
		return rcode;
	}
	public void setRcode(String rcode) {
		this.rcode = rcode;
	}
	
	@Override
	public String toString() {
		return "TMRequestVO [textid=" + textid + ", email=" + email + ", rcode=" + rcode + "]";
	}
	
}
