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
        Location loc = new Location();
        loc.setName("Test Hall");
        loc.setCity("Test City");
        loc.setAddress("Test Address");
        locationRepo.save(loc);

        // Create an event
        Event event = new Event();
        event.setName("Test Event");
        event.setDescription("Description here");
        event.setDate(LocalDate.now());
        event.setCapacity(100L);
        event.setLocation(loc);
        eventRepo.save(event);

        // Create a participant
        Participant participant = new Participant();
        participant.setName("John Doe");
        participant.setEmail("john@example.com");
        participantRepo.save(participant);

        // Register participant
        Registration reg = new Registration();
        reg.setEvent(event);
        reg.setParticipant(participant);
        reg.setRegistrationDate(LocalDate.now());
        registrationRepo.save(reg);

        // Assertions
        assert(!eventRepo.findAll().isEmpty());
        assert(!participantRepo.findAll().isEmpty());
        assert(!registrationRepo.findAll().isEmpty());
    }
}
