package br.com.likwi.advancedMessageQueueProtocol;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload,
                        String exchange,
                        String routingKey) {
        log.info(MessageFormat.format(
                "Publish to {0} using routing key {1}\n\t Payload {2}",exchange,routingKey,payload));

        this.amqpTemplate.convertAndSend(
                exchange, routingKey, payload
        );

        log.info(MessageFormat.format(
                "Published to {0} using routing key {1}\n\t Payload {2}",exchange,routingKey,payload));


    }
}
