package com.smart.contact.configuration;


public class MsgConfig {
	
	private String content;
	private String type;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content=content;
	}
	public String getType() {
		return type;
	}
	public MsgConfig(String content, String type) {
		super();
		this.content = content;
		this.type = type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
