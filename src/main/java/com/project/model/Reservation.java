package com.project.model;

import org.joda.time.DateTime;

public class Reservation {
	

		//  private String name; 
	    private Room room;
		private String occupant;
	    private DateTime startTime; 
	    private DateTime endTime;

	    public Reservation(Room room, String occupant, DateTime startTime,
				DateTime endTime) {
			super();
			this.room = room;
			this.occupant = occupant;
			this.startTime = startTime;
			this.endTime = endTime;
		} 
	    
		public String getOccupant() {
			return occupant;
		}
		public void setOccupant(String occupant) {
			this.occupant = occupant;
		}
		public Room getRoom() {
			return room;
		}
		public void setRoom(Room room) {
			this.room = room;
		}
		public DateTime getStartTime() {
			return startTime;
		}
		public void setStartTime(DateTime startTime) {
			this.startTime = startTime;
		}
		public DateTime getEndTime() {
			return endTime;
		}
		public void setEndTime(DateTime endTime) {
			this.endTime = endTime;
		}

		  @Override
			public String toString() {
				return "Reservation [room=" + room + ", occupant=" + occupant
						+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
			}


}
