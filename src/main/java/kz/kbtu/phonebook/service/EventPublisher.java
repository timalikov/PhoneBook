package kz.kbtu.phonebook.service;


import kz.kbtu.phonebook.event.KafkaEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void publishEvent(String eventData) {
        KafkaEvent kafkaEvent = new KafkaEvent(this, eventData);
        eventPublisher.publishEvent(kafkaEvent);
    }
}