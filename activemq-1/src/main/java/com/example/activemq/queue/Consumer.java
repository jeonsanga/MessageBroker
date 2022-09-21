package com.example.activemq.queue;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class Consumer {

	//소비자 클래스는 메세지를 수신하는데 사용된다
	
	
	//해당목적의 메세지를 읽는다 sang
//	@JmsListener(destination = "sanga-queue")
	public void counsumeMessae(String message) {
		 log.info("Message received from activemq queue---"+message);
	}
}
