package com.ab.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ab.models.Attendee;
import com.ab.models.Event;

public class EventDAOImpl implements EventDAO 
{
	 private Map<Event, List<Attendee>> attendeesPerEvent = new HashMap<>();;
	 private List<Event> eventsList = new ArrayList<>();
	 
	 private static Scanner scan1 = new Scanner(System.in); // For strings
	 private static Scanner scan2 = new Scanner(System.in); // For integers

	
	
	@Override
	public void initializeEventsList()
	{
		eventsList.add(new Event(1001, "Event 1", "20/03/23", new ArrayList<>()));
        eventsList.add(new Event(1002, "Event 2", "23/04/23", new ArrayList<>()));
        eventsList.add(new Event(1003, "Event 3", "08/05/23", new ArrayList<>()));
        eventsList.add(new Event(1004, "Event 4", "19/06/23", new ArrayList<>()));
	}
	 
	@Override
	public void listAllEvents() 
	{
		eventsList.forEach(System.out::println);

	}

	@Override
	public void listIndividualEvent() 
	{
		System.out.print("Enter the event ID: ");
        int eventId = scan2.nextInt();
        boolean found = false;
        for (Event event : eventsList) {
            if (event.getEventId() == eventId) {
                System.out.println(event);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Event not found.");
        }
	}

	@Override
	public void editEvent() 
	{
		System.out.print("Enter the event ID: ");
    	int eventId = scan2.nextInt();
    	boolean found = false;
    	for (Event event : eventsList) 
    	{
	    	if (event.getEventId() == eventId) 
	    	{
		    	found = true;
		    	System.out.println("Current event details:");
		    	System.out.println(event);
		    	System.out.println("Enter new event name: ");
		    	String eventName = scan1.nextLine();
		    	System.out.println("Enter new event date (dd/mm/yy): ");
		    	String eventDate = scan1.nextLine();
		    	event.setEventName(eventName);
		    	event.setEventDate(eventDate);
		    	System.out.println("Event details updated:");
		    	System.out.println(event);
		    	break;
	    	}
    	}
    	if (!found) {
    	System.out.println("Event not found.");
    	}

	}

	@Override
	public void deleteEvent() 
	{
		System.out.print("Enter the event ID: ");
        int eventId = scan2.nextInt();
        boolean found = false;
        for (Event event : eventsList) 
        {
            if (event.getEventId() == eventId) 
            {
                eventsList.remove(event);
                attendeesPerEvent.remove(event);
                System.out.println("Event deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) 
        {
            System.out.println("Event not found.");
        }

	}

	@Override
	public void listAttendees() 
	{
		System.out.print("Enter the event ID: ");
        int eventId = scan2.nextInt();
        boolean found = false;
        for (Event event : attendeesPerEvent.keySet()) {
            if (event.getEventId() == eventId) {
                List<Attendee> attendees = attendeesPerEvent.get(event);
                System.out.println("Attendees for event " + event.getEventName() + ":");
                attendees.forEach(System.out::println);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Event not found.");
        }

	}

	@Override
	public void addAttendee() 
	{
		 System.out.print("Enter the event ID: ");
	        int eventId = scan2.nextInt();
	        boolean found = false;
	        for (Event event : eventsList) 
	        {
	            if (event.getEventId() == eventId) 
	            {
	                System.out.println("Enter attendee name: ");
	                String attendeeName = scan1.nextLine();
	                System.out.println("Enter attendee email: ");
	                String attendeeEmail = scan1.nextLine();
	                Attendee attendee = new Attendee(attendeeName, attendeeEmail);
	                List<Attendee> attendees = attendeesPerEvent.getOrDefault(event, new ArrayList<>());
	                attendees.add(attendee);
	                attendeesPerEvent.put(event, attendees);
	                System.out.println("Attendee added to event " + event.getEventName() + " successfully.");
	                found = true;
	                break;
	            }
	        }
	        if (!found) 
	        {
	            System.out.println("Event not found.");
	        }

	}

	@Override
	public void deleteAttendee() 
	{
		System.out.print("Enter the event ID: ");
        int eventId = scan2.nextInt();
        boolean found = false;
        for (Event event : attendeesPerEvent.keySet()) 
        {
            if (event.getEventId() == eventId) 
            {
                List<Attendee> attendees = attendeesPerEvent.get(event);
                System.out.print("Enter the attendee email: ");
                String attendeeEmail = scan1.nextLine();
                boolean attendeeFound = false;
                for (Attendee attendee : attendees) 
                {
                    if (attendee.getEmail().equals(attendeeEmail)) 
                    {
	                    attendees.remove(attendee);
	                    System.out.println("Attendee " + attendeeEmail + " has been removed from event " + eventId);
	                    attendeeFound = true;
	                    break;
                    }
                }
                if (!attendeeFound) 
                {
                	System.out.println("Attendee " + attendeeEmail + " not found in event " + eventId);
                }
                found = true;
                break;
                
            }
        }
        if (!found) 
        {
        System.out.println("Event " + eventId + " not found");
        }

	}

}
