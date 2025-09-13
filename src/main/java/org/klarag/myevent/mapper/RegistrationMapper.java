package org.klarag.myevent.mapper;

import org.klarag.myevent.dto.Registration;
import org.klarag.myevent.entity.RegistrationEntity;

public class RegistrationMapper {
    public static RegistrationEntity toEntity(Registration registration) {
        return new RegistrationEntity(registration.getId(), registration.getEvent(), registration.getParticipant(), registration.getRegistrationDate());
    }

    public static Registration toRegistrationDto(RegistrationEntity registrationEntity) {
        return new Registration(registrationEntity.getId(), registrationEntity.getEvent(), registrationEntity.getParticipant(), registrationEntity.getRegistrationDate());
    }
}
