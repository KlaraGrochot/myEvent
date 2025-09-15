package org.klarag.myevent.service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.klarag.myevent.dto.Event;
import org.klarag.myevent.dto.Participant;
import org.klarag.myevent.entity.EventEntity;
import org.klarag.myevent.exception.EventNotFoundException;
import org.klarag.myevent.mapper.EventMapper;
import org.klarag.myevent.mapper.ParticipantMapper;
import org.klarag.myevent.repository.EventRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    //list of all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(EventMapper::toEventDto)
                .collect(Collectors.toList());
    }

    //CRUD
    public Event getEventById(Long id) {
        EventEntity eventEntity = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Nie znaleziono wydarzenia."));
        return EventMapper.toEventDto(eventEntity);
    }

    public Event addEvent(Event event) {
        EventEntity eventEntity = EventMapper.toEntity(event);
        EventEntity saved = eventRepository.save(eventEntity);
        return EventMapper.toEventDto(saved);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        EventEntity eventEntity = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Nie znaleziono wydarzenia."));
        eventEntity.setName(updatedEvent.getName());
        eventEntity.setDescription(updatedEvent.getDescription());
        eventEntity.setCapacity(updatedEvent.getCapacity());
        eventEntity.setLocation(updatedEvent.getLocation());
        eventEntity.setDate(updatedEvent.getDate());
        return EventMapper.toEventDto(eventRepository.save(eventEntity));
    }

    public void deleteEvent(Long id) {eventRepository.deleteById(id);}

    //capacity checker
    public Long getEventCapacity(Long id) {
        return getEventById(id).getCapacity();
    }

    public List<Participant> getParticipantsForEvent(Long eventId) {
        EventEntity eventEntity = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Nie znaleziono wydarzenia."));

        // Pull participants from registrations
        return eventEntity.getRegistrations().stream()
                .map(reg -> ParticipantMapper.toParticipantDto(reg.getParticipant()))
                .collect(Collectors.toList());
    }
}
