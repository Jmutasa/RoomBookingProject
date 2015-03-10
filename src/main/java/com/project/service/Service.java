package com.project.service;

import com.project.model.Message;
import com.project.model.Reservation;
import com.project.model.Schedule;

public class Service {
	
RoomBookingServiceImpl serviceImpl = new RoomBookingServiceImpl();
Message message = new Message();

public String bookRoom(Reservation e){
	
	if (serviceImpl.isAvailable(e) && serviceImpl.isInRoomList(e)){
		serviceImpl.book(e);
		System.out.println("Room has been Booked!"  +  Schedule.getScheduleList().toString());
		
		return message.getMessageList().get(0);
	}
	
	if (!serviceImpl.isAvailable(e)) {
		System.out.println("Room one is booked for part or all of the period you attempted to book for.");
		return message.getMessageList().get(1);


	}
	
	return message.getMessageList().get(2);

}

}
