package org.klarag.myevent.dto;

import org.klarag.myevent.entity.LocationEntity;

import java.time.LocalDate;

public class Event {
    private Long id;
    private String name;
    private String description;
    private LocalDate date;
    private Long capacity;
    private LocationEntity location;

    //constructors
    public Event() {}

    public Event(Long id, String name, String description, LocalDate date, Long capacity, LocationEntity location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.capacity = capacity;
        this.location = location;
    }

    //getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getCapacity() {
        return capacity;
    }

    public LocationEntity getLocation() {
        return location;
    }
}
