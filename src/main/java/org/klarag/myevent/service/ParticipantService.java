package org.klarag.myevent.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.klarag.myevent.dto.Participant;
import org.klarag.myevent.entity.ParticipantEntity;
import org.klarag.myevent.exception.AlreadyRegisteredException;
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
    public Participant registerParticipant(Participant participant) {
        participantRepository.findByEmail(participant.getEmail())
                .ifPresent( p -> {
                    throw new AlreadyRegisteredException(participant.getEmail());
                        });
        ParticipantEntity participantEntity = ParticipantMapper.toEntity(participant);
        ParticipantEntity saved = participantRepository.save(participantEntity);
        return ParticipantMapper.toParticipantDto(saved);
    }

    public Participant getParticipantById(Long id) {
        ParticipantEntity entity = participantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Participant with id " + id + " not found!"));
        return ParticipantMapper.toParticipantDto(entity);
    }
}
