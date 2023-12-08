package kz.kbtu.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "phonebook")
    public void listen(String message) {
        // Обработка полученного сообщения
        System.out.println("Received message: " + message);
    }
}