package org.launchcode.codingevents.models;


import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class Event extends AbstractEntity {

//    @Id
//    @GeneratedValue
//    private int id;

    //private static int nextId = 1;

    @NotBlank(message = "Name must not be blank. Name is required.")
    @Size(min = 3, max = 50 )
    private String name;

    @Size(max =500, message = "Description too long")
    private String description;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    private  EventType type;

    @NotBlank(message = "Location must not be blank")
    @NotBlank(message = "Location must not be blank. Name is required.")
    private String location;

    @Positive(message="Number of attendees must be one or more.")
    private int numberOfAttendees;

    public Event(String name, String description, String contactEmail, EventType type, String location, int numberOfAttendees) {
        // this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.type = type;
        this.location = location;
        this.numberOfAttendees = numberOfAttendees;

    }

    public Event(){
        /*this.id = nextId;
        nextId++;*/
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

//    public int getId() {
//        return id;
//    }

    @Override
    public String toString() {
        return name;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Event)) return false;
//        Event event = (Event) o;
//        return id == event.id;
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}
