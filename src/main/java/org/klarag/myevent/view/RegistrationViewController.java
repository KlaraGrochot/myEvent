package org.klarag.myevent.view;

import org.klarag.myevent.dto.Participant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/participants")
public class RegistrationViewController {

    @GetMapping("/new")
    public String newParticipantForm(Model model) {
        // Add an empty Participant DTO to the model
        model.addAttribute("participant", new Participant());
        return "participants/new"; // Thymeleaf template
    }
}
