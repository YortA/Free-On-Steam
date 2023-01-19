package com.fos.main.gamestats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GameStatsApplication {
	public static void main(String[] args) {
		SpringApplication.run(GameStatsApplication.class, args);
	}

}
