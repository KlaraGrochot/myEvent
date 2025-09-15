package org.klarag.myevent.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.klarag.myevent.dto.Participant;
import org.klarag.myevent.service.ParticipantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/participants")
public class ParticipantController {
    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @Operation(
            summary = "Get participant by ID",
            description = "Fetch a single participant by their unique identifier"
    )
    @ApiResponse(responseCode = "200", description = "Participant found")
    @ApiResponse(responseCode = "404", description = "Participant not found")
    @GetMapping("/{id}")
    public ResponseEntity<Participant> getParticipantById(@PathVariable Long id) {
        return ResponseEntity.ok(participantService.getParticipantById(id));
    }

    @Operation(
            summary = "Add a new participant",
            description = "Registers a new participant in the system"
    )
    @ApiResponse(responseCode = "200", description = "Participant created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid participant data")
    @PostMapping
    public ResponseEntity<Participant> addParticipant(@Valid @RequestBody Participant newParticipant) {
        Participant created = participantService.registerParticipant(newParticipant);
        return ResponseEntity.ok(created);
    }
}
