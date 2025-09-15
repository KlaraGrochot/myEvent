package org.klarag.myevent.view;

import org.klarag.myevent.dto.Event;
import org.klarag.myevent.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventViewController {

    private final EventService eventService;

    public EventViewController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public String listEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "events/list";
    }

    @GetMapping("/new")
    public String newEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "events/new";
    }

    @GetMapping("/{id}")
    public String eventDetails(@PathVariable Long id, Model model) {
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);
        return "events/details";
    }

    @GetMapping("/{id}/registrations")
    public String eventRegistrations(@PathVariable Long id, Model model) {
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);

        var participants = eventService.getParticipantsForEvent(id);
        model.addAttribute("participants", participants);

        return "events/registrations";
    }
}
