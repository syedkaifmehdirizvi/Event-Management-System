package com.ab.controllers;

import java.util.List;

import com.ab.services.EventService;



public class EventController 
{
	//Introduce Dependency
	private EventService eventService;
	
	// Constructor (DI point)
	public EventController(EventService eventService){
	
		this.eventService = eventService;
	
	}
		
	public void initializeEventsList(){
		
		this.eventService.initializeEventsList();
	
	}
	
	public void listAllEvents(){
		
		this.eventService.listAllEvents();
	}
	
	public void listIndividualEvent(){
	
		this.eventService.listIndividualEvent();
	
	}
	
	public void editEvent() 
	{
		this.eventService.editEvent();
		
	}
	
	public void deleteEvent() 
	{
		this.eventService.deleteEvent();
		
	}

	public void listAttendees() 
	{
		this.eventService.listAttendees();
		
	}

	public void addAttendee() 
	{
		this.eventService.addAttendee();
		
	}

	public void deleteAttendee() 
	{
		this.eventService.deleteAttendee();
		
	}
			
			
			
}
