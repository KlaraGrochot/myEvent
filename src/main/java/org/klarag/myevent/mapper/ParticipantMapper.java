package org.klarag.myevent.mapper;


import org.klarag.myevent.dto.Participant;
import org.klarag.myevent.entity.ParticipantEntity;

public class ParticipantMapper {
    public static ParticipantEntity toEntity(Participant participant) {
        return new ParticipantEntity(participant.getId(), participant.getName(), participant.getEmail());
    }

    public static Participant toParticipantDto(ParticipantEntity participantEntity) {
        return new Participant(participantEntity.getId(), participantEntity.getName(), participantEntity.getEmail());
    }
}
