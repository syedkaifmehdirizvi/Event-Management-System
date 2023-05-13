import java.util.ArrayList;
import java.util.List;

public class Event 
{
	// Variables (Attributes)
	private int eventId;
    private String eventName;
    private String eventDate;
    private List<Attendee> attendeeList;
    
    // Constructor
    public Event(int eventId, String eventName, String eventDate, List<Attendee> attendeeList)
    {
    	this.eventId = eventId;
    	this.eventName = eventName;
    	this.eventDate = eventDate;
    	this.attendeeList = attendeeList;	    	
  
    }
    
    // toString Method
    @Override
	public String toString() 
    {
		return "Event [Event Id = " + eventId + ", Event Name = " + eventName + ", Event Date = " + eventDate + "]";
	}
    
     // Getters
    public int getEventId() 
    {
        return eventId;
    }

	public String getEventName() 
    {
        return eventName;
    }

    public String getEventDate() 
    {
        return eventDate;
    }
    
    public List<Attendee> getAttendeeList()
    {
    	return attendeeList;
    }
    

    // Setters
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	
	public void setAttendeeList(List<Attendee> attendeeList) 
	{
		this.attendeeList = attendeeList;
	}
		

	    
			
		
}
