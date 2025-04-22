package kafka.kafkaLearning;

import kafka.kafkaLearning.KafkaListeners;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaListeners kafkaListeners;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate, KafkaListeners kafkaListeners) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaListeners = kafkaListeners;
    }

    @PostMapping
    public void publish(@RequestBody MessageRequest request) {
        kafkaTemplate.send("warrior", request.message());
    }

    @GetMapping
    public List<String> getMessages() {
        return kafkaListeners.getReceivedMessages();
    }
}
