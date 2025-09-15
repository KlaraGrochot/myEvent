package org.klarag.myevent.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.klarag.myevent.dto.Event;
import org.klarag.myevent.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) { this.eventService = eventService; }

    @Operation(
            summary = "Get all events",
            description = "Returns a list of all available events"
    )
    @ApiResponse(responseCode = "200", description = "Successfully retrieved events")
    @GetMapping
    public ResponseEntity<List<Event>> getEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @Operation(
            summary = "Get event by ID",
            description = "Fetch a single event by its unique identifier"
    )
    @ApiResponse(responseCode = "200", description = "Event found")
    @ApiResponse(responseCode = "404", description = "Event not found")
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @Operation(
            summary = "Create a new event",
            description = "Registers a new event in the system"
    )
    @ApiResponse(responseCode = "200", description = "Event created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid event data")
    @PostMapping
    public ResponseEntity<Event> createEvent(@Valid @RequestBody Event newEvent) {
        Event created = eventService.addEvent(newEvent);
        return ResponseEntity.ok(created);
    }

    @Operation(
            summary = "Update an event",
            description = "Updates an existing event in the system"
    )
    @ApiResponse(responseCode = "200", description = "Event updated successfully")
    @ApiResponse(responseCode = "400", description = "Invalid event data")
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
        Event event = eventService.updateEvent(id, updatedEvent);
        return ResponseEntity.ok(event);
    }

    @Operation(
            summary = "Delete an event",
            description = "Deletes an existing event"
    )
    @ApiResponse(responseCode = "200", description = "Event deleted successfully")
    @ApiResponse(responseCode = "404", description = "Event not found")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
