package com.example.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    RabbitMessage rabbitMessage;

    @GetMapping(value = "/getAll")
    public void getAll(){
            rabbitMessage.setDescription("description");
            rabbitMessage.setName("name");
            rabbitTemplate.convertAndSend("directDeadLineExceeded", "routingDeadlineEx", rabbitMessage.toString());
    }

}
