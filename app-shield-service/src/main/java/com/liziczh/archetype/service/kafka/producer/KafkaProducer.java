package com.liziczh.archetype.service.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	public void sendMsg(String topic, Object msg) {
		kafkaTemplate.send(topic, msg);
	}
}
