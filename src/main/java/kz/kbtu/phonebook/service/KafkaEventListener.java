package kz.kbtu.phonebook.service;

import kz.kbtu.phonebook.event.KafkaEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaEventListener {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @EventListener
    public void handleDataChangeEvent(KafkaEvent event) {
        // Process the event received from Kafka
        kafkaTemplate.send("phonebook", event.getEventData());
        System.out.println("Received DataChangeEvent: " + event.getEventData());
    }
}
