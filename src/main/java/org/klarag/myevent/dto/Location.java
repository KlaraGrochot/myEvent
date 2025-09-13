package org.klarag.myevent.dto;

public class Location {
    private Long id;
    private String name;
    private String city;
    private String address;

    public Location() {}

    public Location(Long id, String name, String city, String address) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}
