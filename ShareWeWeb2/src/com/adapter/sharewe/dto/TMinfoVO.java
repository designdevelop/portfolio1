package com.adapter.sharewe.dto;

public class TMinfoVO {

	private String textid;
	private String title;
	private String email;
	private String area;
	private String content;
	private String tmdate;
	private String talent;
	private String mytalent;
	private String wishtalent;
	private String seq;
	public String getTextid() {
		return textid;
	}
	public void setTextid(String textid) {
		this.textid = textid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTmdate() {
		return tmdate;
	}
	public void setTmdate(String tmdate) {
		this.tmdate = tmdate;
	}
	public String getTalent() {
		return talent;
	}
	public void setTalent(String talent) {
		this.talent = talent;
	}
	public String getMytalent() {
		return mytalent;
	}
	public void setMytalent(String mytalent) {
		this.mytalent = mytalent;
	}
	public String getWishtalent() {
		return wishtalent;
	}
	public void setWishtalent(String wishtalent) {
		this.wishtalent = wishtalent;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	@Override
	public String toString() {
		return "TMinfoVO [textid=" + textid + ", title=" + title + ", email=" + email + ", area=" + area + ", content="
				+ content + ", tmdate=" + tmdate + ", talent=" + talent + ", mytalent=" + mytalent + ", wishtalent=" + wishtalent + ", seq=" + seq + "]";
	}
}
