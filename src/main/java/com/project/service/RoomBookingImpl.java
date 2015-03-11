package com.project.service;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import com.project.model.Booking;
import com.project.model.Room;
import com.project.model.RoomList;
import com.project.model.Schedule;

public class RoomBookingImpl{

	public boolean isAvailable(Booking Booking) {

		for (Booking element : Schedule.getScheduleList()) {
			if (element.getRoom().getName() == Booking.getRoom().getName()) {

				Interval scheduleInterval = new Interval(new DateTime(
						element.getStartTime()), new DateTime(
						element.getEndTime()));
				Interval BookingInterval = new Interval(new DateTime(
						Booking.getStartTime()), new DateTime(
						Booking.getEndTime()));

				if (scheduleInterval.overlaps(BookingInterval)) {
					// System.out.println("Room is already Booked for this time!");

					return false;
				}

			}

		}

		return true;
	}

	public boolean isInRoomList(Room room) {

		for (Room element : RoomList.getRoomList()) {
			if (element.getName() == room.getName()) {
				return true;
			}
		}

		return false;

	}

	public void book(Booking Booking) {
		Schedule.addToScheduleList(Booking);

	}

}
