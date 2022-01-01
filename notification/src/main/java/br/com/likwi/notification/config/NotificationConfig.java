package br.com.likwi.notification.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class NotificationConfig {

    //these properties came from application.yml

    @Value("${rabbitmq.exchanges.internal}")
    private String interalExchange;

    @Value("${rabbitmq.queues.notification}")
    private String notificationQueue;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotificationRoutingKey;
}
