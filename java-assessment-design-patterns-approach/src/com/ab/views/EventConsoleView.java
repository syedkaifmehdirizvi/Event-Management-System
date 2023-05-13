package com.ab.views;

import com.ab.controllers.EventController;

public class EventConsoleView 
{
	private EventController eventController;
	
	public EventConsoleView(EventController eventController)
	{
		this.eventController = eventController;
	}
	
	// Method to initialise event list
	public void initializeEventsList() 
	{
		this.eventController.initializeEventsList();
		
	}
	
	 // Method to display the menu
    public void displayMenu() 
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
    public void handleMenuChoice(int choice) 
    {
        switch (choice) 
        {
            case 1:
                this.eventController.listAllEvents();
                break;
            case 2:
                this.eventController.listIndividualEvent();
                break;
            case 3:
                this.eventController.editEvent();
                break;
            case 4:
                this.eventController.deleteEvent();
                break;
            case 5:
                this.eventController.listAttendees();
                break;
            case 6:
                this.eventController.addAttendee();
                break;
            case 7:
                this.eventController.deleteAttendee();
                break;
            case 8:
                System.out.println("Exiting program...");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }


			
}
	
