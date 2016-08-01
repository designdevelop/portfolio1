package com.adapter.sharewe.dto;

public class CommentVO {
	private String comment_text = null;
	private String email = null;
	private String cmtdate = null;
	private String comseq = null;
	private String textid = null;
	private String nickname = null;
	
	public String getNickname() {
		return nickname;
	}
	public String getComment_text() {
		return comment_text;
	}
	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCmtdate() {
		return cmtdate;
	}
	public void setCmtdate(String cmtdate) {
		this.cmtdate = cmtdate;
	}
	public String getComseq() {
		return comseq;
	}
	public void setComseq(String comseq) {
		this.comseq = comseq;
	}
	public String getTextid() {
		return textid;
	}
	public void setTextid(String textid) {
		this.textid = textid;
	}
	
	@Override
	public String toString() {
		return "CommentVO [comment=" + comment_text + ", email=" + email + ", cmtdate=" + cmtdate + ", comseq=" + comseq
				+ ", textid=" + textid + "]";
	}
	
	
}
