package com.adapter.sharewe.dto;

public class TMHashtagVO {

	private String textid;
	private String helper;
	private String talent;
	private String mytalent;
	private String wishtalent;

	public String getTextid() {
		return textid;
	}

	public void setTextid(String textid) {
		this.textid = textid;
	}

	public String getHelper() {
		return helper;
	}

	public void setHelper(String helper) {
		this.helper = helper;
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

	@Override
	public String toString() {
		return "TMHashtagVO [textid=" + textid + ", helper=" + helper + ", talent=" + talent + ", mytalent=" + mytalent
				+ ", wishtalent=" + wishtalent + "]";
	}

}
