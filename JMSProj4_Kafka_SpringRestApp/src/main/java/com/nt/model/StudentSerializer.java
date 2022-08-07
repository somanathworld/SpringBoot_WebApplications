package com.nt.model;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentSerializer implements Serializer<Student> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {

	}

	@Override
	public byte[] serialize(String topic, Student stud) {
		byte[] retVal = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			retVal = objectMapper.writeValueAsString(stud).getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}
	@Override
	public void close() {
	}

}
