import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EventManagement 
{

    // Declare collections
    private static Map<Event, List<Attendee>> attendeesPerEvent = new HashMap<>();
    private static List<Event> eventsList = new ArrayList<>();

    // Scanner Objects
    private static Scanner scan1 = new Scanner(System.in); // For strings
    private static Scanner scan2 = new Scanner(System.in); // For integers

    public static void main(String[] args) 
    {
        // Initialize the events list
        initializeEventsList();

        // Display the menu and handle user input
        int choice;
        do 
        {
            displayMenu();
            choice = scan2.nextInt();
            handleMenuChoice(choice);
        } 
        while (choice != 8);
    }
    
    
    
    
    
    
    
    
    
    
    
//*************************** Methods ********************************************************    

    // Method to initialise the events list
    private static void initializeEventsList() 
    {
        eventsList.add(new Event(1001, "Event 1", "20/03/23", new ArrayList<>()));
        eventsList.add(new Event(1002, "Event 2", "23/04/23", new ArrayList<>()));
        eventsList.add(new Event(1003, "Event 3", "08/05/23", new ArrayList<>()));
        eventsList.add(new Event(1004, "Event 4", "19/06/23", new ArrayList<>()));
    }

    // Method to display the menu
    private static void displayMenu() 
    {
        System.out.println("********************* MENU **************************");
        System.out.println("=====================================================");
        System.out.println("         1. List All events");
        System.out.println("         2. List an individual event");
        System.out.println("         3. Edit an event");
        System.out.println("         4. Delete an event");
        System.out.println("         5. List the attendees attending an event");
        System.out.println("         6. Add an attendee to an event");
        System.out.println("         7. Delete an attendee from an event");
        System.out.println("         8. Exit");
        System.out.println();
        System.out.print("Enter your choice: ");
    }

    // Method to handle the user's menu choice
    private static void handleMenuChoice(int choice) 
    {
        switch (choice) 
        {
            case 1:
                listAllEvents();
                break;
            case 2:
                listIndividualEvent();
                break;
            case 3:
                editEvent();
                break;
            case 4:
                deleteEvent();
                break;
            case 5:
                listAttendees();
                break;
            case 6:
                addAttendee();
                break;
            case 7:
                deleteAttendee();
                break;
            case 8:
                System.out.println("Exiting program...");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }





	// Method to list all events ***************************
    private static void listAllEvents() 
    {
        eventsList.forEach(System.out::println);
    }

    // Method to list an individual event **************************
    private static void listIndividualEvent() 
    {
        System.out.print("Enter the event ID: ");
        int eventId = scan2.nextInt();
        boolean found = false;
        for (Event event : eventsList) 
        {
            if (event.getEventId() == eventId) 
            {
                System.out.println(event);
                found = true;
                break;
            }
        }
        if (!found) 
        {
            System.out.println("Event not found.");
        }
    }

    // Method to edit an event *******************************
    private static void editEvent() 
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
    
    // Method to delete an event ***********************************
    private static void deleteEvent() 
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
    
    // Method to list attendees for an event *****************************
    private static void listAttendees() 
    {
        System.out.print("Enter the event ID: ");
        int eventId = scan2.nextInt();
        boolean found = false;
        for (Event event : attendeesPerEvent.keySet()) 
        {
            if (event.getEventId() == eventId) 
            {
                List<Attendee> attendees = attendeesPerEvent.get(event);
                System.out.println("Attendees for event " + event.getEventName() + ":");
                attendees.forEach(System.out::println);
                found = true;
                break;
            }
        }
        if (!found) 
        {
            System.out.println("Event not found.");
        }
    }
    
    // Method to add an attendee to an event **************************************
    private static void addAttendee() 
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
    
    // Method to delete an Attendee **********************************************8
    private static void deleteAttendee() 
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


