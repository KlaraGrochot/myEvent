package org.klarag.myevent.repository;

import org.klarag.myevent.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
