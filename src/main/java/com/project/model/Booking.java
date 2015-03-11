package com.project.model;

import org.joda.time.DateTime;

public class Booking implements Comparable<Booking> {
	

		//  private String name; 
	    private Room room;
		private String occupant;
	    private DateTime startTime; 
	    private DateTime endTime;

	    public Booking(Room room, String occupant, DateTime startTime,
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
				return "Bookings [room=" + room.getName() + ", occupant=" + occupant
						+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
			}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((endTime == null) ? 0 : endTime.hashCode());
			result = prime * result
					+ ((occupant == null) ? 0 : occupant.hashCode());
			result = prime * result + ((room == null) ? 0 : room.hashCode());
			result = prime * result
					+ ((startTime == null) ? 0 : startTime.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Booking other = (Booking) obj;
			if (endTime == null) {
				if (other.endTime != null)
					return false;
			} else if (!endTime.equals(other.endTime))
				return false;
			if (occupant == null) {
				if (other.occupant != null)
					return false;
			} else if (!occupant.equals(other.occupant))
				return false;
			if (room == null) {
				if (other.room != null)
					return false;
			} else if (!room.equals(other.room))
				return false;
			if (startTime == null) {
				if (other.startTime != null)
					return false;
			} else if (!startTime.equals(other.startTime))
				return false;
			return true;
		}

		public int compareTo(Booking booking) {
			// TODO Auto-generated method stub
			return room.getName().compareTo(booking.getRoom().getName());

		}
}
