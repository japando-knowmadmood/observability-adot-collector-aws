package com.grupoversus.opentelemetry.app.b.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-b")
public class ServiceBController {

    @GetMapping("/response")
    public String respond() {
        if (Math.random() > 0.7) { // Simular error aleatorio
            throw new RuntimeException("Simulated failure");
        }
        return "Hello from Service-B!";
    }
}
