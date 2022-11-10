package org.launchcode.codingevents.models;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Event extends AbstractEntity {
//    @Id
//    @GeneratedValue
//    private int id;

    //private static int nextId = 1;
    @NotBlank(message = "Name must not be blank. Name is required.")
    @Size(min = 3, max = 50 )
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

//    private  EventType type;
    @ManyToOne
    @NotNull(message = "Category is required")
    private EventCategory eventCategory;

    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();

    @NotBlank(message = "Location must not be blank")
    @NotBlank(message = "Location must not be blank. Name is required.")
    private String location;

    @Positive(message="Number of attendees must be one or more.")
    private int numberOfAttendees;

    public Event(String name, EventCategory eventCategory, String location, int numberOfAttendees) {
        // this();
        this.name = name;
        this.eventCategory = eventCategory;
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

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
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

    public List<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag){
        this.tags.add(tag);
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
