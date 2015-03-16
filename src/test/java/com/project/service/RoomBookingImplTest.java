package com.project.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.project.model.Booking;
import com.project.model.Room;
import com.project.model.RoomList;
import com.project.model.Schedule;
import com.project.service.RoomBookingService;

public class RoomBookingImplTest {

	RoomBookingService service = new RoomBookingService();
	Room room1;
	Room room2;
	Booking booking1;
	Booking booking2;
	Booking booking3;
	RoomList roomlist = new RoomList();
	List<Booking> compareList = new ArrayList<Booking>();

	@Before
	public void setup() {
	        Schedule.clearScheduleList();
		RoomList.clearRoomList();
		room1 = new Room("one");
		room2 = new Room("five");

		booking1 = new Booking(room1, null, null, null);

		// set booking1 details
		booking1.setOccupant("Bob");
		booking1.setStartTime(new DateTime(2015, 02, 01, 10, 30, 0, 0));
		booking1.setEndTime(new DateTime(2015, 02, 01, 11, 30, 0, 0));

		booking2 = new Booking(room1, null, null, null);

		// set booking1 details
		booking2.setOccupant("Jenny");
		booking2.setStartTime(new DateTime(2015, 02, 01, 11, 30, 0, 0));
		booking2.setEndTime(new DateTime(2015, 02, 01, 12, 30, 0, 0));

		booking3 = new Booking(room2, null, null, null);

		// set booking1 details
		booking3.setOccupant("Jenny");
		booking3.setStartTime(new DateTime(2015, 02, 01, 11, 30, 0, 0));
		booking3.setEndTime(new DateTime(2015, 02, 01, 12, 30, 0, 0));

		Schedule.addToScheduleList(booking1);
		RoomList.addToRoomListList(room1);

	}

	@After()
	public void teardown() {
		// clear schedule
		Schedule.getScheduleList().clear();
		RoomList.getRoomList().clear();
	}

	@Test
	public void testisNotAvaialable() {
		assertFalse(service.isAvailable(booking1));
	}

	@Test
	public void testisAvaialable() {
		assertTrue(service.isAvailable(booking2));
	}

	@Test
	public void testBookRoom() {
		service.book(booking2);
		compareList.add(booking1);
		compareList.add(booking2);
		//assertEquals(2, Schedule.getScheduleList().size());
		assertEquals(2, compareList.size());

		//assertTrue(Schedule.getScheduleList().size() == 2);
		assertEquals(Schedule.getScheduleList(), compareList);
	}
	


	@Test
	public void testInRoomList() {
		assertFalse(service.isInRoomList(booking3.getRoom()));
		assertTrue(service.isInRoomList(booking1.getRoom()));

	}

}

