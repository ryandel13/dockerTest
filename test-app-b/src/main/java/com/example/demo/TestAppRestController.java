package com.example.demo;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("radio")
public class TestAppRestController {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Receiver receiver;


    @GetMapping("/{text}")
    public Boolean send(@PathVariable String text) {
        System.out.println("OUT: " + text);

        rabbitTemplate.convertAndSend(RabbitController.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!" + text);
       

        return false;
    }

}
