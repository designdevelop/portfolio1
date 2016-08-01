package com.adapter.sharewe.dto;

public class MemberInfoVO {
	private String email;
	private String pwd;
	private String nickname;
	private String gender;
	private String address;
	private String phone;
	private String job;
	private String picture;
	private String kakao;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getKakao() {
		return kakao;
	}
	public void setKakao(String kakao) {
		this.kakao = kakao;
	}
	@Override
	public String toString() {
		return "MemberInfoVO [email=" + email + ", pwd=" + pwd + ", nickname=" + nickname + ", gender=" + gender
				+ ", address=" + address + ", phone=" + phone + ", job=" + job + ", picture=" + picture + ", kakao="
				+ kakao + "]";
	}
}
