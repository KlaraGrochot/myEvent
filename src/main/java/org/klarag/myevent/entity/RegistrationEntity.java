package org.klarag.myevent.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class RegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event")
    private EventEntity event;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private ParticipantEntity participant;

    private LocalDate registrationDate;

    public RegistrationEntity() {}

    public RegistrationEntity(Long id, EventEntity event, ParticipantEntity participant, LocalDate registrationDate) {
        this.id = id;
        this.event = event;
        this.participant = participant;
        this.registrationDate = registrationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EventEntity getEvent() {
        return event;
    }

    public void setEvent(EventEntity eventEntity) {
        this.event = eventEntity;
    }

    public ParticipantEntity getParticipant() {
        return participant;
    }

    public void setParticipant(ParticipantEntity participant) {
        this.participant = participant;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
