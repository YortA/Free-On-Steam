package com.fos.main.gamestats.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.fos.main.gamestats.service.GameStatsCircuitBreakerService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value="/gamestats")
public class GameStatsController {

//	private final WebClient.Builder loadBalancedWebClientBuilder;
//	//private final ReactorLoadBalancerExchangeFilterFunction lbFunction;
//	
//	public GameStatsController(WebClient.Builder webClientBuilder/*,ReactorLoadBalancerExchangeFilterFunction lbFunction */) {
//		this.loadBalancedWebClientBuilder = webClientBuilder;
//		//this.lbFunction = lbFunction;
//	}

	Logger log = LoggerFactory.getLogger(this.getClass());
	
//	place this in circuit?
//	@Autowired
//	GameStatsService service;
	
	@Autowired
	GameStatsCircuitBreakerService gamesCircuit;
	
	@GetMapping("/hi/{name}")
	public Mono<String> greet(@PathVariable(value = "name") String name) {
		System.out.println("Inside greet() API");
		return gamesCircuit.greet(name);
	}
	
//	@GetMapping("/hello")
//	public Mono<String> greet2(@RequestParam(value = "name", defaultValue = "EmptyName") String name) throws InterruptedException {
//		System.out.println("Inside greet2() API");
//		return gamesCircuit.greet2(name);
//	}
	
	
	
	
	
	
	
	
	
//  ###### RestTemplate Example ######
	
//	@GetMapping("/hello")
//	public String greet3(@RequestParam(value = "name", defaultValue = "EmptyName") String name) {
//		System.out.println("Inside greet3() API");
//		
//		// DISCOVERYCLIENT CLIENT IN-FUNCTION SOLUTION
//		String gUri = null;
//		List<ServiceInstance> gInstance = client.getInstances("single-game");
//		if(gInstance != null && !gInstance.isEmpty()) {
//			gUri = gInstance.get(0).getUri().toString();
//		}
//		System.out.println("Instance:" + gUri);
//		String output = new RestTemplate().getForObject(gUri + "/game/test", String.class);
//		
//		
//		// RestTemplate Example
//		String output = template.getForObject("http://single-game/game/test", String.class);
//		System.out.println("return from getobject: " + output);
//		return output;
//		return gamesCircuit.greet3(name);
//	}
	
}
