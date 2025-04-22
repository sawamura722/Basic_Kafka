package kafka.kafkaLearning;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "warrior",
            groupId = "warriorId"
    )
    void listener(String data) {
        System.out.println("Listener received: " + data);
    }
}
