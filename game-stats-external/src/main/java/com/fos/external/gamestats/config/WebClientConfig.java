package com.fos.external.gamestats.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	@Bean
	@LoadBalanced
	WebClient webClient() {
		// change allowable size of API call response
		final int size = 16 * 1024 * 1024;
		final ExchangeStrategies strategies = ExchangeStrategies.builder()
			.codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
			.build();
		
		WebClient webClient = WebClient
				.builder()
				//.baseUrl("https://api.steampowered.com/ISteamApps/GetAppList/v2/")
				.defaultCookie("cookieKey", "cookieValue")
				.exchangeStrategies(strategies)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
		return webClient;
	}
}