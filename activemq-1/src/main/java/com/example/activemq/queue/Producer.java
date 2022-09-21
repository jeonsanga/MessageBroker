package com.example.activemq.queue;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.activemq.dto.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/produce")
public class Producer {
	
	//Activemq Queue에 메시지를 보내는데 사용된다.
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue queue;
	
	@PostMapping("/message")
	public Student sendMessage(@RequestBody Student student) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			//자바객체를 json문자열로 출력하기 위해서
			String studentAsJson = mapper.writeValueAsString(student);
			jmsTemplate.convertAndSend(queue, studentAsJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return student;
	}
}
