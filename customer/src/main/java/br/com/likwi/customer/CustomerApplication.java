package br.com.likwi.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// need this to inject RabbitMQMessageProducer
@SpringBootApplication(scanBasePackages = {
        "br.com.likwi.customer",
        "br.com.likwi.advancedMessageQueueProtocol"
})
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "br.com.likwi.clients"
)
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
