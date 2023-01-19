package com.fos.main.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class FosGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FosGatewayApplication.class, args);
	}

}
