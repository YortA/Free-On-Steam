package com.fos.main.gamestats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Mono;

// Future is a computational object that will be available sometime later during async.
// LOOKUP
// @Rety
// @Bulkhead
@Service
public class GameStatsCircuitBreakerService {

	@Autowired
	WebClient.Builder webClientBuilder;
	
	//@CircuitBreaker(name = "game-stats")
	public Mono<String> greet(String name) {	// Mono creates ASYNC functionality.
		System.out.println("Inside greet() CIRCUIT");
		return webClientBuilder.build().get()
				.uri("http://single-game/game/test")
				.retrieve()
				.bodyToMono(String.class);
				//.onErrorResume(e -> greet2(name));	// uses a callback function
				//.onErrorResume(e -> Mono.just("Error " + e.getMessage()));		// get our error msg
				//.block(); method will create a SYNC functionality.
	}
	
//	public Mono<String> greetFallback(String name, RuntimeException ex) {
//		System.out.println("Inside greet() FALLBACK");
//		return Mono.just("Failed. Using Fallback Method");
//	}
	
	
	
	//@CircuitBreaker(name = "game-stats") 
//	public Mono<String> greet2(String name) {
//		System.out.println("Inside greet2() CIRCUIT");
//		
//		Mono<String> output = webClientBuilder.build().get().uri("http://single-game/game/test2")
//				.retrieve().bodyToMono(String.class);
//		output.subscribe(msg -> System.out.println("MonoText = " + msg));	// output the data we received
//		return output;
//				//.map(obj -> String.format("%s, %s!", obj, name));
//	}
}
