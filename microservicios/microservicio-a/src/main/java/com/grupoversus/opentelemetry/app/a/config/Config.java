package com.grupoversus.opentelemetry.app.a.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {

	@Bean
	WebClient.Builder webClientBuilder() {
	    return WebClient.builder();
	}

}
