package com.wxr.entity;

public class QuanXian {

	private String value;
	private String title;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public QuanXian(String value, String title) {
		super();
		this.value = value;
		this.title = title;
	}
	public QuanXian() {
		super();
	}
	@Override
	public String toString() {
		return "QuanXian [value=" + value + ", title=" + title + "]";
	}
	
}
