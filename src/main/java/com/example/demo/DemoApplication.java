package com.example.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    RabbitMessage rabbitMessage;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        rabbitMessage.setDescription("description");
        rabbitMessage.setName("name");
        rabbitTemplate.convertAndSend("directDeadLineExceeded", "routingDeadlineEx", rabbitMessage.toString());
    }
}
