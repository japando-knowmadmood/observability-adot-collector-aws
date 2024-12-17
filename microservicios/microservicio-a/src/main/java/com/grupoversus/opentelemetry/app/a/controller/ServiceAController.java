package com.grupoversus.opentelemetry.app.a.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;

@RestController
@RequestMapping("/service-a")
public class ServiceAController {

    private final WebClient webClient;

    public ServiceAController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://service-b:8081").build();
    }

    @GetMapping("/call-service-b")
    public String callServiceB() {
        try {
           return webClient.get()
                .uri("/service-b/response")
                .retrieve()
                .bodyToMono(String.class)
                .block(); 
        } catch (Exception e) {
            // Marca el span actual como error
            Span currentSpan = Span.current();
            currentSpan.setStatus(StatusCode.ERROR, "Error calling service-b");
            currentSpan.setAttribute("error.message", e.getMessage());
            currentSpan.setAttribute("error.type", e.getClass().getSimpleName());
            throw e; // Re-lanza el error si es necesario
        }
        
    }
}

