package com.fos.main.singlegame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SingleGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingleGameApplication.class, args);
	}

}
