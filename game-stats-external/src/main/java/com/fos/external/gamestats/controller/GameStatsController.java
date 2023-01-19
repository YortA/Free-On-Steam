package com.fos.external.gamestats.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fos.external.gamestats.dto.App;
import com.fos.external.gamestats.dto.GameStatsDTO;
import com.fos.external.gamestats.dto.SteamApp;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class GameStatsController {
	
	// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/annotation/Scheduled.html
	// cron <minute> <hour> <day-of-month> <month> <day-of-week> <command>
//	@Scheduled(fixedRate = 50000)
//	//@Scheduled(cron = "0 12 * * ?", zone = "America/Los_Angeles")
//	public void scheduleTestTask() {
//		System.out.println("Test Schedule #" + counter++);
//	}
	
	@Autowired
	WebClient webClient;
	
	@GetMapping("/getApps")
	// ############## MONO ######################
	// can also pass <?> for any json object
	// flux is used for multiple objects
	public Mono<SteamApp> getAllApps() {
		System.out.println("Starting getAllApps();");
		Mono<SteamApp> response = webClient.get()
				.uri("https://api.steampowered.com/ISteamApps/GetAppList/v2/")
				.retrieve()
				.bodyToMono(SteamApp.class);
		// blocking way -- need to figure out non-blocking with subscribe
		SteamApp steamApp = response.block();
		
		List<App> apps = new ArrayList<>();
		apps = steamApp.getApplist().getApps()
		.stream()
		.sorted(Comparator.comparingInt(App::getAppid))
		.collect(Collectors.toList());
		
		apps.forEach(val -> System.out.println("ID: " + val.getAppid() + '\n' + "NAME: " + val.getName()));
		System.out.println("Total Number of unique IDs: " + apps.size());
		
		System.out.println("Ending getAllApps();");
		return response;
	}
	
	
	
	// ############## RESPONSE ENTITY ######################
	// can also pass <?> for any json object
	// flux is used for multiple objects
//	public ResponseEntity<SteamApp> getAllApps() {
//		System.out.println("Starting getAllApps();");
//		SteamApp response = webClient.get()
//				.uri("https://api.steampowered.com/ISteamApps/GetAppList/v2/")
//				.retrieve()
//				.bodyToMono(SteamApp.class)
//				.block();
//				//.doOnError(throwable -> System.out.println("Failed to fetch Steam Apps. Reason: " + throwable));
//		
//		List<App> apps = new ArrayList<>();
//		
////		response.getApplist().getApps()
////				.stream()
////				.forEach(val -> System.out.println("ID: " + val.getAppid() + '\n' + "NAME: " + val.getName()));
//		apps = response.getApplist().getApps()
//		.stream()
//		.collect(Collectors.toList());
//		
//		apps.forEach(val -> System.out.println("ID: " + val.getAppid() + '\n' + "NAME: " + val.getName()));
//		System.out.println("Total Number of unique IDs: " + apps.size());
//		//apps.forEach(System.out::println);
//		
//		
//		//apps = response.collectList().block();
//		//response.subscribe(obj -> obj.getApplist().getApps())
//		
//		
//		//response.collectList().block()
//		//response.subscribe(value -> System.out.println("Consume REST API: " + value.getApplist().getApps().toString()));
//		System.out.println("Ending getAllApps();");
//		return new ResponseEntity<SteamApp>(response, HttpStatus.OK);
//		//return response;
//	}
	
}
