package com.adapter.sharewe.dto;

public class GraphBarVO {
	private int cnt;
	private int up; 
	private int down;
	private String targetemail;
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getUp() {
		return up;
	}
	public void setUp(int up) {
		this.up = up;
	}
	public int getDown() {
		return down;
	}
	public void setDown(int down) {
		this.down = down;
	}
	public String getTargetemail() {
		return targetemail;
	}
	public void setTargetemail(String targetemail) {
		this.targetemail = targetemail;
	}
	@Override
	public String toString() {
		return "GraphBarVO [cnt=" + cnt + ", up=" + up + ", down=" + down + ", targetemail=" + targetemail + "]";
	}
	
	

}
