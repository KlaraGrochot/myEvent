package org.klarag.myevent.mapper;

import org.klarag.myevent.dto.Event;
import org.klarag.myevent.entity.EventEntity;

public class EventMapper {
    public static EventEntity toEntity(Event event) {
        return new EventEntity(event.getId(), event.getName(), event.getDescription(), event.getDate(), event.getCapacity(), event.getLocation());
    }

    public static Event toEventDto(EventEntity eventEntity) {
        return new Event(eventEntity.getId(), eventEntity.getName(), eventEntity.getDescription(), eventEntity.getDate(), eventEntity.getCapacity(), eventEntity.getLocation());
    }
}
