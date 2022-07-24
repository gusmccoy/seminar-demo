package racemanagement.trektrak.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import racemanagement.trektrak.DTO.EventDTO;
import racemanagement.trektrak.Entity.Event;
import racemanagement.trektrak.Repository.EventRepository;

@Service
public class EventService {
    private EventRepository eventRepository;

    public EventService(EventRepository repository) {
        this.eventRepository = repository;
    }

    public List<EventDTO> getAllEvents() {
        var events = (List<Event>) eventRepository.findAll();
        var eventDTOs = new ArrayList<EventDTO>();
        events.forEach(e -> {
            eventDTOs.add(new EventDTO(e.getId(), e.getUserId(), e.getEventName()));
        });
        return eventDTOs;
    }

    public List<EventDTO> getAllEventsByCreateId(int userId) {
        var events = eventRepository.findAllByUserId(userId);
        var eventDTOs = new ArrayList<EventDTO>();

        if(events.isPresent() && !events.get().isEmpty()) {
            events.get().forEach(e -> {
                eventDTOs.add(new EventDTO(e.getId(), e.getUserId(), e.getEventName()));
            });
        }
        return eventDTOs;
    }

    public int saveNewEvent(EventDTO newEvent) {
        var event = Event.builder()
            .active(true)
            .eventName(newEvent.getName())
            .userId(newEvent.getCreateUserId())
            .createTime(new Date())
            .build();
        return eventRepository.save(event).getId();
    }

    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }

    public void updateEvent(EventDTO updatedEvent) {
        var event = Event.builder()
            .id(updatedEvent.getId())
            .eventName(updatedEvent.getName())
            .userId(updatedEvent.getCreateUserId())
            .build();
        eventRepository.save(event);
    }
}
