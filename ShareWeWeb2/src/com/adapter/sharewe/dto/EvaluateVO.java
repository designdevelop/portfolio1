package com.adapter.sharewe.dto;

public class EvaluateVO {
	private String content;
	private String voteremail;
	private String evaluateid;
	private String targetemail;
	private String flag;
	private String thumbimg;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getVoteremail() {
		return voteremail;
	}

	public void setVoteremail(String voteremail) {
		this.voteremail = voteremail;
	}

	public String getEvaluateid() {
		return evaluateid;
	}

	public void setEvaluateid(String evaluateid) {
		this.evaluateid = evaluateid;
	}

	public String getTargetemail() {
		return targetemail;
	}

	public void setTargetemail(String targetemail) {
		this.targetemail = targetemail;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getThumbimg() {
		return thumbimg;
	}

	public void setThumbimg(String thumbimg) {
		this.thumbimg = thumbimg;
	}

	@Override
	public String toString() {
		return "EvaluateVO [content=" + content + ", voteremail=" + voteremail + ", evaluateid=" + evaluateid
				+ ", targetemail=" + targetemail + ", flag=" + flag + ", thumbimg=" + thumbimg + "]";
	}
}
