package org.klarag.myevent;

import org.junit.jupiter.api.Test;
import org.klarag.myevent.entity.*;
import org.klarag.myevent.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private ParticipantRepository participantRepo;

    @Autowired
    private LocationRepository locationRepo;

    @Autowired
    private RegistrationRepository registrationRepo;

    @Test
    void testDatabase() {
        // Create a location
        LocationEntity loc = new LocationEntity();
        loc.setName("Test Hall");
        loc.setCity("Test City");
        loc.setAddress("Test Address");
        locationRepo.save(loc);

        // Create an event
        EventEntity eventEntity = new EventEntity();
        eventEntity.setName("Test Event");
        eventEntity.setDescription("Description here");
        eventEntity.setDate(LocalDate.now());
        eventEntity.setCapacity(100L);
        eventEntity.setLocation(loc);
        eventRepo.save(eventEntity);

        // Create a participant
        ParticipantEntity participant = new ParticipantEntity();
        participant.setName("John Doe");
        participant.setEmail("john@example.com");
        participantRepo.save(participant);

        // Register participant
        RegistrationEntity reg = new RegistrationEntity();
        reg.setEvent(eventEntity);
        reg.setParticipant(participant);
        reg.setRegistrationDate(LocalDate.now());
        registrationRepo.save(reg);

        // Assertions
        assert(!eventRepo.findAll().isEmpty());
        assert(!participantRepo.findAll().isEmpty());
        assert(!registrationRepo.findAll().isEmpty());
    }
}
