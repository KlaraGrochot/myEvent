package org.klarag.myevent.mapper;

import org.klarag.myevent.dto.Location;
import org.klarag.myevent.entity.LocationEntity;

public class LocationMapper {
    public static LocationEntity toEntity(Location location) {
        return new LocationEntity(location.getId(), location.getName(), location.getCity(), location.getAddress());
    }

    public static Location toLocationDto(LocationEntity locationEntity) {
        return new Location(locationEntity.getId(), locationEntity.getName(), locationEntity.getCity(), locationEntity.getAddress());
    }
}
