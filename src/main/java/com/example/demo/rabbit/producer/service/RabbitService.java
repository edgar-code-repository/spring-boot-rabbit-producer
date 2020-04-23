package com.example.demo.rabbit.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.rabbit.producer.config.RabbitConfiguration;
import com.example.demo.rabbit.producer.dto.CustomMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class RabbitService {

	static final Logger logger = LoggerFactory.getLogger(RabbitService.class);
	
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    public void sendMessage(CustomMessage message) throws JsonProcessingException {
        logger.debug("[RabbitService][sendMessage][START]");
        
        ObjectMapper objectMapper = new ObjectMapper();
        String strJson = objectMapper.writeValueAsString(message);

        logger.debug("[RabbitService][sendMessage][json sent: " + strJson + "]");
        
        rabbitTemplate.convertAndSend(RabbitConfiguration.RABBIT_EXCHANGE, RabbitConfiguration.RABBIT_ROUTING_KEY, strJson);

        logger.debug("[RabbitService][sendMessage][END]");
    }    
	
}
