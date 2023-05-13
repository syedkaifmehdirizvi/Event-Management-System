package com.ab.services;

import com.ab.daos.EventDAO;

public class EventServiceImpl implements EventService
{
	private EventDAO eventDAO;
	
	// Constructor
	public EventServiceImpl(EventDAO eventDAO)  // When you create EmployeeServiceImpl object in main class: 
	{													 // new EmployeeServiceImpl(new EmployeeDAOImpl()); 
		
		this.eventDAO = eventDAO;
	}

	// Methods (linking methods from DAO layer)
	@Override
	public void initializeEventsList() 
	{
		this.eventDAO.initializeEventsList();
		
	}

	@Override
	public void listAllEvents() 
	{
		this.eventDAO.listAllEvents();
		
	}

	@Override
	public void listIndividualEvent() 
	{
		this.eventDAO.listIndividualEvent();
		
	}

	@Override
	public void editEvent() 
	{
		this.eventDAO.editEvent();
		
	}

	@Override
	public void deleteEvent() 
	{
		this.eventDAO.deleteEvent();
		
	}

	@Override
	public void listAttendees() 
	{
		this.eventDAO.listAttendees();
		
	}

	@Override
	public void addAttendee() 
	{
		this.eventDAO.addAttendee();
		
	}

	@Override
	public void deleteAttendee() 
	{
		this.eventDAO.deleteAttendee();
		
	}
}
