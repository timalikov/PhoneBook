package kz.kbtu.phonebook.event;

import org.springframework.context.ApplicationEvent;

public class KafkaEvent extends ApplicationEvent {
    private String eventData;
    public KafkaEvent(Object source, String eventData) {
        super(source);
        this.eventData = eventData;
    }
    public String getEventData() {
        return eventData;
    }
}
