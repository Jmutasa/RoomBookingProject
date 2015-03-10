package com.project.model;

import java.util.ArrayList;
import java.util.List;

public class Message {
	
	private List<String> messageList = new ArrayList<String>();

	public Message() {
		messageList.add(0, "Room has been booked!");
		messageList.add(1, "Room one is booked for part or all of the period you attempted to book for.");
		messageList.add(2, "Room does not exist");
	}

	public List<String> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}

}
