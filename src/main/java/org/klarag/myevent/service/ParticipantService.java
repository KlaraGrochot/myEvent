package org.klarag.myevent.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.klarag.myevent.dto.Participant;
import org.klarag.myevent.entity.ParticipantEntity;
import org.klarag.myevent.mapper.ParticipantMapper;
import org.klarag.myevent.repository.ParticipantRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    //register participant
    public ParticipantEntity registerParticipant(Participant participant) {
        participantRepository.findByEmail(participant.getEmail())
                .ifPresent( p -> {
                    throw new EntityExistsException("Participant with email " + participant.getEmail() + " already exists");
                        });
        ParticipantEntity participantEntity = ParticipantMapper.toEntity(participant);
        return participantRepository.save(participantEntity);
    }
}
