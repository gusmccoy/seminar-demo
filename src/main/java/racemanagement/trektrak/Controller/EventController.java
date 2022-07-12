package racemanagement.trektrak.Controller;

import org.springframework.web.bind.annotation.RestController;

import racemanagement.trektrak.Entity.Event;
import racemanagement.trektrak.Service.EventService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80", "https://www.trek-trak.gusmccoy.dev"})
@RestController
public class EventController {

    private EventService eventService;

    List<Event> events = new ArrayList<Event>();

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/event/all")
	public List<Event> getAllEvents() {
        System.out.print("Retrieving All Exisiting Events...");
		return eventService.getAllEvents();
	}

    @PostMapping("/event/new")
    public void saveNewEvent(@RequestBody Event newEvent) {
        eventService.saveNewEvent(newEvent);
    }

    @DeleteMapping("/event/delete/{id}")
    public void deleteEvent(@PathVariable int id) {
        System.out.println("Deleting Event by ID: ID = " + id);
        eventService.deleteEvent(id);
    }

    @PutMapping("/event/update")
    public void updateEvent(@RequestBody Event updatedEvent) {
        eventService.updateEvent(updatedEvent);
    }
}
