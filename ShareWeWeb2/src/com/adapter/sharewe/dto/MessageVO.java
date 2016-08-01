package com.adapter.sharewe.dto;

public class MessageVO {

	private String receiver;
	private String sender;
	private String tfdate;
	private String content;
	private String checked;
	private String messageid;
	private String title;
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getTfdate() {
		return tfdate;
	}
	public void setTfdate(String tfdate) {
		this.tfdate = tfdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public String getMessageid() {
		return messageid;
	}
	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "MessageVO [receiver=" + receiver + ", sender=" + sender + ", tfdate=" + tfdate + ", content=" + content
				+ ", checked=" + checked + ", messageid=" + messageid + ", title=" + title + "]";
	}
	
}
