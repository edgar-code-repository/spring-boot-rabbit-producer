package com.example.demo.rabbit.producer.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.rabbit.producer.dto.CustomMessage;
import com.example.demo.rabbit.producer.service.RabbitService;

@RestController
public class MessageController {

	static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	private RabbitService rabbitService; 
	
	@PostMapping("/messages")
	public ResponseEntity<String> postMessage(@RequestBody CustomMessage message) throws Exception {
		logger.debug("[MessageController][postMessage][START]");
		logger.debug("[MessageController][postMessage][Message content: " + message.getContent() + "]");
		
		rabbitService.sendMessage(message);
		
		logger.debug("[MessageController][postMessage][END]");
		return new ResponseEntity<String>("Message was sent to RabbitMQ: " + message.toString(), HttpStatus.CREATED);
	}
	
}
