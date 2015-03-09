package com.project.service;

import com.project.model.Reservation;

public class Service {
	
RoomBookingServiceImpl serviceImpl = new RoomBookingServiceImpl();

public boolean bookRoom(Reservation e){
	
	if (serviceImpl.isAvailable(e) && serviceImpl.isInRoomList(e)){
		serviceImpl.book(e);
		System.out.println("Room has been booked for given timeslot");
		return true;
	}
	
	if (!serviceImpl.isInRoomList(e)){
		System.out.println("The room you are trying to book does not exist");
	}
	
	if (!serviceImpl.isAvailable(e)) {
		System.out.println("The room is not available for given timeslot");
	}
	
	return false;

}

}
