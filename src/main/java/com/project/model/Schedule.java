package com.project.model;

import java.util.ArrayList;
import java.util.List;

public final class Schedule {

	private static List<Reservation> scheduleList = new ArrayList<Reservation>();
		
	private Schedule(){
		
		scheduleList = new ArrayList<Reservation>();
		
		}
	public static void addToScheduleList(Reservation e){
		scheduleList.add(e);
	}
	
	public static void removeFromScheduleList(Reservation e){
		scheduleList.remove(e);
	}
	
	public static void clearScheduleList(){
		scheduleList.clear();
	}
	
	public static List<Reservation> getScheduleList() {
		return scheduleList;
	}
	
	public static void setScheduleList(List<Reservation> schedule) {
		Schedule.scheduleList = schedule;
	}
	
	public static void printScheduleList() {
      scheduleList.toString();
	
	}
	
	
	
}
