package com.adapter.sharewe.dto;

public class MemberCheckVO {
	private String email;
	private String joinDate;
	private String joinCheck;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getJoinCheck() {
		return joinCheck;
	}
	public void setJoinCheck(String joinCheck) {
		this.joinCheck = joinCheck;
	}
	
	@Override
	public String toString() {
		return "MemberCheckVO [email=" + email + ", joinDate=" + joinDate + ", joinCheck=" + joinCheck + "]";
	}
	
}
