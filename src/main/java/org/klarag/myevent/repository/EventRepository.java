package org.klarag.myevent.repository;

import org.klarag.myevent.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
