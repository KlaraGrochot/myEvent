package org.klarag.myevent.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.klarag.myevent.mapper.EventMapper;
import org.klarag.myevent.mapper.ParticipantMapper;
import org.klarag.myevent.service.EventService;
import org.klarag.myevent.service.ParticipantService;
import org.klarag.myevent.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/events")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final EventService eventService;
    private final ParticipantService participantService;

    public RegistrationController(RegistrationService registrationService,
                                  EventService eventService,
                                  ParticipantService participantService) {
        this.registrationService = registrationService;
        this.eventService = eventService;
        this.participantService = participantService;
    }

    @Operation(
            summary = "Register participant for an event",
            description = "Registers a participant to an event using their IDs"
    )
    @ApiResponse(responseCode = "200", description = "Participant successfully registered")
    @ApiResponse(responseCode = "400", description = "Event full, participant already registered, or invalid IDs")
    @PostMapping("/{eventId}/register/{participantId}")
    public ResponseEntity<?> registerParticipant(@PathVariable Long eventId, @PathVariable Long participantId) {
        try {
            var event = eventService.getEventById(eventId);
            var eventEntity = EventMapper.toEntity(event);
            var participant = participantService.getParticipantById(participantId);
            var participantEntity = ParticipantMapper.toEntity(participant);

            var registration = registrationService.registerForEvent(eventEntity, participantEntity);

            return ResponseEntity.ok(registration);

        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
