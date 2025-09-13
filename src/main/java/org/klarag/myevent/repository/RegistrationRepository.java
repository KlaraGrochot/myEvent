package org.klarag.myevent.repository;

import org.klarag.myevent.entity.EventEntity;
import org.klarag.myevent.entity.ParticipantEntity;
import org.klarag.myevent.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Long> {
    boolean existsByEventAndParticipant(EventEntity event, ParticipantEntity participant);
    long countByEvent(EventEntity event);
}
