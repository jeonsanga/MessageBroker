package com.example.redis.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.redis.entity.Person;

public interface PersonRedisRepository extends CrudRepository<Person, String>{

}
