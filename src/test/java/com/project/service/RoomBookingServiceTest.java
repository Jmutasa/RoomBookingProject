package com.project.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.project.model.Reservation;
import com.project.model.Room;
import com.project.model.RoomList;
import com.project.model.Schedule;

public class RoomBookingServiceTest {

	RoomBookingServiceImpl service = new RoomBookingServiceImpl();
	Room room1;
	Room room2;
	Reservation reservation1;
	Reservation reservation2;
	Reservation reservation3;
	RoomList roomlist = new RoomList();
	@Before
	public void setup() {

		room1 = new Room("one");
		room2 = new Room("five");

		reservation1 = new Reservation(room1, null, null, null);

		// set reservation1 details
		reservation1.setOccupant("Bob");
		reservation1.setStartTime(new DateTime(2015, 02, 01, 10, 30, 0, 0));
		reservation1.setEndTime(new DateTime(2015, 02, 01, 11, 30, 0, 0));

		reservation2 = new Reservation(room1, null, null, null);

		// set reservation1 details
		reservation2.setOccupant("Jenny");
		reservation2.setStartTime(new DateTime(2015, 02, 01, 11, 30, 0, 0));
		reservation2.setEndTime(new DateTime(2015, 02, 01, 12, 30, 0, 0));

		reservation3 = new Reservation(room2, null, null, null);

		// set reservation1 details
		reservation3.setOccupant("Jenny");
		reservation3.setStartTime(new DateTime(2015, 02, 01, 11, 30, 0, 0));
		reservation3.setEndTime(new DateTime(2015, 02, 01, 12, 30, 0, 0));

		Schedule.addToScheduleList(reservation1);
		RoomList.addToRoomListList(room1);

	}

	@After()
	public void teardown() {
		// clear schedule
		Schedule.clearScheduleList();
	}

	@Test
	public void testisNotAvaialable() {
		assertFalse(service.isAvailable(reservation1));
	}

	@Test
	public void testisAvaialable() {
		assertTrue(service.isAvailable(reservation2));
	}

	@Test
	public void testBookRoom() {
		service.book(reservation2);
		assertTrue(Schedule.getScheduleList().size() == 2);
	}

	@Test
	public void testInRoomList() {
		assertFalse(service.isInRoomList(reservation3));
		assertTrue(service.isInRoomList(reservation1));

	}

}
