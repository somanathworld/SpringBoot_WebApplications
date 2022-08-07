package com.nt.model;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentDeserializer implements Deserializer<Student> {

	@Override public void close() {

	  }

	  @Override public void configure(Map<String, ?> arg0, boolean arg1) {

	  }

	  @Override
	  public Student deserialize(String arg0, byte[] arg1) {
	    ObjectMapper mapper = new ObjectMapper();
	    Student stud = null;
	    try {
	      stud = mapper.readValue(arg1, Student.class);
	    } catch (Exception e) {

	      e.printStackTrace();
	    }
	    return stud;
	  }

}
