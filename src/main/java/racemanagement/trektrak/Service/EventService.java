package racemanagement.trektrak.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import racemanagement.trektrak.Entity.Event;
import racemanagement.trektrak.Repository.EventRepository;

@Service
public class EventService {
    private EventRepository eventRepository;

    public EventService(EventRepository repository) {
        this.eventRepository = repository;
    }

    public List<Event> getAllEvents() {
        return (List<Event>) eventRepository.findAll();
    }

    public void saveNewEvent(Event newEvent) {
        eventRepository.save(newEvent);
    }

    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }

    public void updateEvent(Event updatedEvent) {
        eventRepository.save(updatedEvent);
    }
}
