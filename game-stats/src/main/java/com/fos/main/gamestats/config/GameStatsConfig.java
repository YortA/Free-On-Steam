/*
 * 
 *  THIS WILL OVERWRITE AND CREATE A CUSTOM DEFAULT HARDCODED LIST FOR SERVERS.
 *  THIS WILL OVERWRITE THE AUTO DISCOVERY CREATED IN THE LOAD BALANCER WITH CONSUL/EUREKA
 * 
 */


//package com.fos.main.gamestats.config;
//
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.cloud.client.DefaultServiceInstance;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import reactor.core.publisher.Flux;
//
////https://spring.io/guides/gs/spring-cloud-loadbalancer/
//// If I want to create a custom list of instances (hard-coded) use this config with @LoadBalancerClient
//@Configuration
//public class GameStatsConfig {
//	
//	@Bean
//	@Primary
//	ServiceInstanceListSupplier serviceInstanceListSupplier() {
//		return new DefaultServiceInstanceListSupplier("single-game");
//	}
//	
//}
//
//class DefaultServiceInstanceListSupplier implements ServiceInstanceListSupplier {
//
//	private final String serviceId;
//	
//	DefaultServiceInstanceListSupplier(String servicedId) {
//		this.serviceId = servicedId;
//	}
//	
//	@Override
//	public String getServiceId() {
//		return this.serviceId;
//	}
//	
//	@Override
//	public Flux<List<ServiceInstance>> get() {
//		System.out.println("Generating Default List");
//		return Flux.just(Arrays
//				.asList(new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8200, false)));
//		// add more MS to the list if I want to discover and balance them
//		//,)new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 8300, false)));
//	}
//}