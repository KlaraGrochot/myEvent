package org.klarag.myevent;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDate date;
    private Long capacity;

    @ManyToOne
    private Location location;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
