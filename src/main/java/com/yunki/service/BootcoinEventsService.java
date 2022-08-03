package com.yunki.service;

import com.yunki.entity.Bootcoin;
import com.yunki.events.Event;
import com.yunki.events.EventType;
import com.yunki.events.BootcoinCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class BootcoinEventsService {
	
	@Autowired
	private KafkaTemplate<String, Event<?>> producer;
	
	@Value("${topic.bootcoin.name:bootcoins}")
	private String topicBootcoin;
	
	public void publish(Bootcoin bootcoin) {

		BootcoinCreatedEvent created = new BootcoinCreatedEvent();
		created.setData(bootcoin);
		created.setId(UUID.randomUUID().toString());
		created.setType(EventType.CREATED);
		created.setDate(new Date());

		this.producer.send(topicBootcoin, created);
	}
	
	

}
