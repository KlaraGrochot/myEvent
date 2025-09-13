package org.klarag.myevent.dto;

import org.klarag.myevent.entity.EventEntity;
import org.klarag.myevent.entity.ParticipantEntity;

import java.time.LocalDate;

public class Registration {
    private Long id;
    private EventEntity event;
    private ParticipantEntity participant;
    private LocalDate registrationDate;

    public Registration() {}

    public Registration(Long id, EventEntity event, ParticipantEntity participant, LocalDate registrationDate) {
        this.id = id;
        this.event = event;
        this.participant = participant;
        this.registrationDate = registrationDate;
    }

    public Long getId() {
        return id;
    }

    public EventEntity getEvent() {
        return event;
    }

    public ParticipantEntity getParticipant() {
        return participant;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
}
