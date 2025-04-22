package kafka.kafkaLearning;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KafkaListeners {

    private final List<String> receivedMessages = new ArrayList<>();

    public List<String> getReceivedMessages() {
        return new ArrayList<>(receivedMessages);  // Return a copy to avoid concurrent modification
    }

    @KafkaListener(
            topics = "warrior",
            groupId = "warriorId"
    )
    void listener(String data) {
        System.out.println("Listener received: " + data);
        receivedMessages.add(data);
    }
}
