package com.example.demo;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration
@Data
public class RabbitMessage implements Serializable {
    private String name;
    private String description;

}
