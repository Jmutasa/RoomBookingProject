package com.project.service;

import com.project.model.Reservation;

public interface RoomBookingServiceInterface {
	
	public boolean isAvailable(Reservation reservation);
	public boolean isInRoomList(Reservation reservation);
	public void book(Reservation reservation);

}
