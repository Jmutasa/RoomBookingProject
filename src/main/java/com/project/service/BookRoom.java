package com.project.service;

import com.project.model.Booking;
import com.project.model.Message;

public class BookRoom {
	
RoomBookingService service = new RoomBookingService();
Message message = new Message();

public String bookRoom(Booking booking) {
	
	if (service.isAvailable(booking) && service.isInRoomList(booking.getRoom())){
		service.book(booking);	
		return null;
	}
	
	if (!service.isAvailable(booking)) {
		return message.getMessage(0, booking.getRoom());

	}
	
	else { return message.getMessage(1, booking.getRoom()); }
	
	
	

}

}
