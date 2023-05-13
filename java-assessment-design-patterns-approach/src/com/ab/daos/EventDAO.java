package com.ab.daos;

public interface EventDAO 
{
	public void initializeEventsList();
	public void listAllEvents();
	public void listIndividualEvent();
	public void editEvent();
	public void deleteEvent();
	public void listAttendees();
	public void addAttendee();
	public void deleteAttendee();
	
}
