package com.nt.model;

import lombok.Data;

@Data
public class Customer {

	private Integer cno;
	private String cname;
	private String country="";
	private String languages[] = new String[] {"English", "Hinid"};
	private String state;
	private String hobbies[] = new String[] {"Reading", "Workout"};

}
