package com.project.cucumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.project.model.Reservation;
import com.project.model.Room;
import com.project.model.RoomList;
import com.project.model.Schedule;
import com.project.service.Service;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class RoomBookingStepDefinition {

	Reservation reservation;
	Room room;
	DateTimeFormatter format = DateTimeFormat.forPattern("MM/dd/YYYY HH:mm");
	Service service = new Service();

	@Before
	public void setup() {
		RoomList.clearRoomList();
		Schedule.clearScheduleList();
	}

	@Given("^the following rooms:$")
	public void the_following_rooms(List<Map<String, String>> data)
			throws Throwable {
		// Add rooms to RoomList
		for (Map<String, String> row : data) {
			room = new Room(row.get("Name"));
			RoomList.addToRoomListList(room);
		}

	}

	@Given("^the following schedules:$")
	public void the_following_schedules(List<Map<String, String>> data)
			throws Throwable {
		// add following bookings to the schedule
		for (Map<String, String> row : data) {
			room = new Room(row.get("Room Name"));
			DateTime startTime = format.parseDateTime(row.get("Start Time"));
			DateTime endTime = format.parseDateTime(row.get("End Time"));
			reservation = new Reservation(room, row.get("Room Occupant"),
					startTime, endTime);
			Schedule.getScheduleList().add(reservation);
		}
	}

	@When("^I try to book the following rooms:$")
	public void I_try_to_book_the_following_rooms(List<Map<String, String>> data)
			throws Throwable {
		for (Map<String, String> row : data) {
			room = new Room(row.get("Room Name"));
			DateTime startTime = format.parseDateTime(row.get("Start Time"));
			DateTime endTime = format.parseDateTime(row.get("End Time"));
			reservation = new Reservation(room, row.get("Room Occupant"),
					startTime, endTime);
			service.bookRoom(reservation);

		}

	}

	@Then("^I expect the following schedule to be confirmed:$")
	public void I_expect_the_following_schedule_to_be_confirmed(
			List<Map<String, String>> data) throws Throwable {
		List<Reservation> confirmedList = new ArrayList();
		for (Map<String, String> row : data) {
			room = new Room(row.get("Room Name"));
			DateTime startTime = format.parseDateTime(row.get("Start Time"));
			DateTime endTime = format.parseDateTime(row.get("End Time"));
			reservation = new Reservation(room, row.get("Room Occupant"),
					startTime, endTime);
			confirmedList.add(reservation);
		}
		
		assertEquals(Schedule.getScheduleList().size(),confirmedList.size());

	}

	@Then("^I expect the following error messages:$")
	public void I_expect_the_following_error_messages(DataTable arg1)
			throws Throwable {

	}

}
