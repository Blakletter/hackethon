package com.group.hackethon;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@SpringBootApplication
public class HackethonApplication {

	@Bean
	public WebClient.Builder getWebClientBuilder() {
		HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
		return WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient));
	}

	public static void main(String[] args) {
		SpringApplication.run(HackethonApplication.class, args);
	}

}
