package com.project.model;

import java.util.ArrayList;
import java.util.List;

public final class RoomList {
	
	private static List<Room> roomList = new ArrayList<Room>();
	
	public RoomList(){
		roomList = new ArrayList<Room>();
		}
	
	public static void addToRoomListList(Room r){
		roomList.add(r);
	}
	
	public static void removeFromRoomList(Room r){
		roomList.remove(r);
	}
	
	public static void clearRoomList(){
		roomList.clear();
	}
	
	public static List<Room> getRoomList() {
		return roomList;
	}
	
	public static void setRoomList(List<Room> roomList) {
		RoomList.roomList = roomList;
	}

}
