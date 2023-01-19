package com.fos.external.gamestats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fos.external.gamestats.dto.GameStatsDTO;
import com.fos.external.gamestats.dto.SteamApp;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class GameListServiceImpl implements GameListService {

//	@Autowired
//	WebClient webClient;
	//WebClient.Builder webClientBuilder;
	
//	@Scheduled(fixedRate = 25000)
//	public void scheduleTest() {
//		System.out.println("########");
////		Mono<Object[]> response = webClientBuilder.build().get()
////				.uri("https://api.steampowered.com/ISteamApps/GetAppList/v2/")
////				.retrieve()
////				.bodyToMono(Object[].class);
////		Flux<Object[]> response = webClientBuilder.build().get()
////				.uri("https://countriesnow.space/api/v0.1/countries/population/cities")
////				.retrieve()
////				.bodyToFlux(Object[].class);
////		response.subscribe(game -> System.out.println("DATA: " + game));
//		
//		//ObjectMapper objectMapper = new ObjectMapper();
//		
////		Flux<Object> response = webClient.get()
////				.uri("https://api.steampowered.com/ISteamApps/GetAppList/v2/")
////				.retrieve()
////				.bodyToFlux(Object.class);
//		
//		Flux<SteamApp> response = webClient.get()
//				.uri("https://api.steampowered.com/ISteamApps/GetAppList/v2/")
//				.retrieve()
//				.bodyToFlux(SteamApp.class)
//				.doOnError(throwable -> System.out.println("Failed to fetch Steam Apps. Reason: " + throwable));
//		
//		//Object json = objectMapper.readValue(response, Object.class);
//		
//		response.subscribe(value -> System.out.println("Consume REST API: " + value.getApplist().getApps().toString()));
//		
////		response.subscribe(game -> {
////			try {
////				System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response));
////			} catch (JsonProcessingException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		});
//		
//		
//		System.out.println("========");
//		//response.subscribe(value -> System.out.println("Consume REST API: " + value));
//	}
}
