package com.example.activemq.dto;

import org.springframework.core.convert.converter.Converter;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class StringToIntegerConverter implements Converter<String, Integer>{

	@Override
	public Integer convert(String source) {
		log.info("convert source"+source);
		return Integer.valueOf(source);
	}
	
	

}
