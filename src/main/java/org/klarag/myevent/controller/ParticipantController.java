package org.klarag.myevent.controller;

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

    @GetMapping("/{id}")
    public ResponseEntity<Participant> getParticipantById(@PathVariable Long id) {
        return ResponseEntity.ok(participantService.getParticipantById(id));
    }

    @PostMapping
    public ResponseEntity<Participant> addParticipant(@Valid @RequestBody Participant newParticipant) {
        Participant created = participantService.registerParticipant(newParticipant);
        return ResponseEntity.ok(created);
    }
}
