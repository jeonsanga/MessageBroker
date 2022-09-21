package com.example.activemq.queue;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.activemq.dto.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/consume")
public class NewConsumer {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue queue;
	
	@GetMapping("/message")
	public Student cosumeMessage() {
		 Student student = null;
		try {
			//receiveAndConvert : 메세지가 도착할때까지 대갛는 수동적 컴포넌트이다.
			 ObjectMapper mapper = new ObjectMapper();
	            String jsonMessage = (String) jmsTemplate.receiveAndConvert(queue);
	            student = mapper.readValue(jsonMessage, Student.class);

			
		} catch (Exception e) {
			   e.printStackTrace();
		}
		   return student;
	}
	

}
