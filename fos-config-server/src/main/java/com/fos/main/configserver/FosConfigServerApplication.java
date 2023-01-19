package com.fos.main.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class FosConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FosConfigServerApplication.class, args);
	}

}
