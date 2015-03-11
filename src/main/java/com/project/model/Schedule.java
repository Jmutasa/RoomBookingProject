package com.project.model;

import java.util.ArrayList;
import java.util.List;

public final class Schedule {

	private static List<Booking> scheduleList = new ArrayList<Booking>();
		
	private Schedule(){
		
		scheduleList = new ArrayList<Booking>();
		
		}
	public static void addToScheduleList(Booking e){
		scheduleList.add(e);
	}
	
	public static void removeFromScheduleList(Booking e){
		scheduleList.remove(e);
	}
	
	public static void clearScheduleList(){
		scheduleList.clear();
	}
	
	public static List<Booking> getScheduleList() {
		return scheduleList;
	}
	
	public static void setScheduleList(List<Booking> schedule) {
		Schedule.scheduleList = schedule;
	}
	
	public static void printScheduleList() {
      scheduleList.toString();
	
	}
	
	
	
}
