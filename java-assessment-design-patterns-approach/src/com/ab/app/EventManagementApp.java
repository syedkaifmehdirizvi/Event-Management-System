package com.ab.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ab.controllers.EventController;
import com.ab.daos.EventDAOImpl;
import com.ab.models.Attendee;
import com.ab.models.Event;
import com.ab.services.EventServiceImpl;
import com.ab.views.EventConsoleView;

public class EventManagementApp 
{
	
	public static void main(String[] args) 
	{
		EventConsoleView view = new EventConsoleView(
				new EventController(
				new EventServiceImpl(
				new EventDAOImpl()
				)
				)
				);
		
		view.initializeEventsList();		

        // Display the menu and handle user input
        int choice;
        Scanner scan2 = new Scanner(System.in);
        do 
        {
            view.displayMenu();
            choice = scan2.nextInt();
            view.handleMenuChoice(choice);
        } 
        while (choice != 8);

	}

}
