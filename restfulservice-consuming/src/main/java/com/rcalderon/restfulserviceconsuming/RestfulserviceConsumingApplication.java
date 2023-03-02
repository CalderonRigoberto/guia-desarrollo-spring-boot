package com.rcalderon.restfulserviceconsuming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestfulserviceConsumingApplication {

	private static final Logger log = LoggerFactory.getLogger(RestfulserviceConsumingApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(RestfulserviceConsumingApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"http://localhost:9091/api/random", Quote.class);
			log.info(quote.value.quote);
		};
	}
}
