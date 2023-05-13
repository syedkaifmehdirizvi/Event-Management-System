package com.ab.models;

public class Attendee 
{
	// Variables (Attributes)
		private int attendeeId;
		private String name;
		private String email;
		private int phone;
		   // type = List<Event>  name = events
		 
		// Constructor
		public Attendee(String name, String email)
		{
			this.name = name;
			this.email = email;	
			
		}

		@Override
		public String toString() 
		{
			return "Attendee [Name = " + name + ", Email = " + email + "]";
		}
		
		// Getters
		public int getAttendeeId() 
		{
			return attendeeId;
		}

		public String getName() 
		{
			return name;
		}

		public String getEmail() 
		{
			return email;
		}

		public int getPhone() 
		{
			return phone;
		}

		// Setters
		public void setAttendeeId(int attendeeId) 
		{
			this.attendeeId = attendeeId;
		}

		
		public void setName(String name) 
		{
			this.name = name;
		}

		
		public void setEmail(String email) 
		{
			this.email = email;
		}

		
		public void setPhone(int phone) 
		{
			this.phone = phone;
		}
}
