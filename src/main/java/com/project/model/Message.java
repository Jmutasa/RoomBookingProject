package com.project.model;

public class Message {
		
		public String getMessage(int i, Room r) {
			
				    if (i == 0)
				      return "Room" + " " + r.getName() + " " + "is booked for part or all of the period you attempted to book for.";
				    
				    if(i==1){
					     
				    	return "Room" + " " + r.getName() + " " + "does not exist";

				    }
				    
				    else
				    {
				      return null;
				    }
				  }

}


