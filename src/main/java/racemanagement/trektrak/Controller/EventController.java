package racemanagement.trektrak.Controller;

import org.springframework.web.bind.annotation.RestController;

import racemanagement.trektrak.DTO.EventDTO;
import racemanagement.trektrak.Service.EventService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80", "https://www.trek-trak.gusmccoy.dev"})
@RestController
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/event/all")
	public List<EventDTO> getAllEvents() {
		return eventService.getAllEvents();
	}

    @GetMapping("/event/all/{userId}")
	public List<EventDTO> getAllEventsByUserId(@PathVariable int userId) {
		return eventService.getAllEventsByCreateId(userId);
	}

    @GetMapping("/event/all/{userId}/status")
	public List<EventDTO> getAllActiveEventsByUserId(@PathVariable int userId, @RequestParam boolean status) {
		return eventService.getAllEventsByCreateIdAndActiveStatus(userId, status);
	}

    @PostMapping("/event/new")
    public int saveNewEvent(@RequestBody EventDTO newEvent) {
        return eventService.saveNewEvent(newEvent);
    }

    @DeleteMapping("/event/delete/{id}")
    public void deleteEvent(@PathVariable int id) {
        System.out.println("Deleting Event by ID: ID = " + id);
        eventService.deleteEvent(id);
    }

    @PutMapping("/event/update")
    public void updateEvent(@RequestBody EventDTO updatedEvent) {
        eventService.updateEvent(updatedEvent);
    }

    @PutMapping("/event/close-out/{id}")
    public void closeoutEvent(@PathVariable int id) {
        eventService.closeoutEvent(id);
    }
}
