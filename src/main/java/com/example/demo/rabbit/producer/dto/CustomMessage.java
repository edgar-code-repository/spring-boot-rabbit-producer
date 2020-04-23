package com.example.demo.rabbit.producer.dto;

public class CustomMessage {
	
	private int messageId;
	private String content;
	
	public CustomMessage() {
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	@Override
	public String toString() {
		return "CustomMessage [messageId=" + messageId + ", content=" + content + "]";
	}

}
