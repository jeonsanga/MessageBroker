package com.example.activemq.dto;

import org.springframework.core.convert.converter.Converter;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class IntegerToString implements Converter<Integer, String>{@Override
	
	
	public String convert(Integer source) {
	log.info("convert source"+source);
		return String.valueOf(source);
	}
	

}
