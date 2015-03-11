package com.project.service;

import com.project.model.Booking;
import com.project.model.Message;
import com.project.model.CustomException;

public class RoomBookingInterface {
	
RoomBookingImpl serviceImpl = new RoomBookingImpl();
Message message = new Message();

public String bookRoom(Booking booking) throws CustomException {
	
	if (serviceImpl.isAvailable(booking) && serviceImpl.isInRoomList(booking.getRoom())){
		serviceImpl.book(booking);	
		return null;
	}
	
	if (!serviceImpl.isAvailable(booking)) {
		return message.getMessage(0, booking.getRoom());

	}
	
	else { return message.getMessage(1, booking.getRoom()); }

}

}
