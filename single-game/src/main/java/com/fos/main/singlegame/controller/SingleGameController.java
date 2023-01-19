package com.fos.main.singlegame.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/game")
public class SingleGameController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/test")
	public String test() {
		log.info("Inside test()");
		return "Test Successful.";
	}
	
	@GetMapping("/test2")
	public String test2() throws InterruptedException {
		//Thread.sleep(2000);
		log.info("Inside test2()");
		return "Test2 Successful.";
	}
}
