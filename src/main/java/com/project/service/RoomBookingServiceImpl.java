package com.project.service;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import com.project.model.Reservation;
import com.project.model.Room;
import com.project.model.RoomList;
import com.project.model.Schedule;

public class RoomBookingServiceImpl implements RoomBookingServiceInterface {

	public boolean isAvailable(Reservation reservation) {

		for (Reservation element : Schedule.getScheduleList()) {
			if (element.getRoom().getName() == reservation.getRoom().getName()) {

				Interval scheduleInterval = new Interval(new DateTime(
						element.getStartTime()), new DateTime(
						element.getEndTime()));
				Interval reservationInterval = new Interval(new DateTime(
						reservation.getStartTime()), new DateTime(
						reservation.getEndTime()));

				if (scheduleInterval.overlaps(reservationInterval)) {
					// System.out.println("Room is already Booked for this time!");

					return false;
				}

			}

		}

		return true;
	}

	public boolean isInRoomList(Reservation reservation) {

		for (Room element : RoomList.getRoomList()) {
			if (element.getName() == reservation.getRoom().getName()) {
				return true;
			}
		}

		return false;

	}

	public void book(Reservation reservation) {
		Schedule.addToScheduleList(reservation);

	}

}
