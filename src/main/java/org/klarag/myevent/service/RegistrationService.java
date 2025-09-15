package org.klarag.myevent.service;

import jakarta.transaction.Transactional;
import org.klarag.myevent.entity.EventEntity;
import org.klarag.myevent.entity.ParticipantEntity;
import org.klarag.myevent.entity.RegistrationEntity;
import org.klarag.myevent.exception.AlreadyRegisteredException;
import org.klarag.myevent.exception.RegistrationFullException;
import org.klarag.myevent.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
       this.registrationRepository = registrationRepository;
    }

    @Transactional
    public RegistrationEntity registerForEvent(EventEntity event, ParticipantEntity participant) {
        boolean isRegistered = registrationRepository.existsByEventAndParticipant(event, participant);
        if (isRegistered) {
            throw new AlreadyRegisteredException(participant.getEmail());
        }

        long currentRegistrations = registrationRepository.countByEvent(event);
        if (currentRegistrations >= event.getCapacity()) {
            throw new RegistrationFullException(event.getName());
        }

        RegistrationEntity registration = new RegistrationEntity();
        registration.setEvent(event);
        registration.setParticipant(participant);
        registration.setRegistrationDate(LocalDate.now());

        return registrationRepository.save(registration);
    }
}
