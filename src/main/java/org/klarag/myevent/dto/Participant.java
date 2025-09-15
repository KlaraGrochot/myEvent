package org.klarag.myevent.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Participant {
    private Long id;

    @NotBlank(message = "To pole jest wymagane")
    private String name;

    @NotBlank(message = "To pole jest wymagane")
    @Email(message = "Podaj poprawny adres e-mail")
    private String email;

    public Participant() {}

    public Participant(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
