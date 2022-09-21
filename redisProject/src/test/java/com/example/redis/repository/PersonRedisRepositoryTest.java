package com.example.redis.repository;

import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.example.redis.entity.Person;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class PersonRedisRepositoryTest {
	
	 @Autowired
	 private PersonRedisRepository repo;

	 
	 @Autowired
	   RedisTemplate redisTemplate;
	 
	//  @Test
	   void redisConnectionTest() {
	      final String key = "a";
	      final String data = "1";

	      final ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
	      valueOperations.set(key, data);

	      final String result = valueOperations.get(key);
	      assertEquals(data, result);
	   }
	@Test
	void test() {
		Person person = new Person("Park", 20);
		
		repo.save(person);
		
		repo.findById(person.getId());
		
		repo.count();
	}
	
	//@Test
	void ip() {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String ip = req.getHeader("X-FORWARDED-FOR");
		if (ip == null)
			ip = req.getRemoteAddr();
		
		System.out.println(ip);
	}


}
