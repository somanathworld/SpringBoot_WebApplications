package com.nt.mode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private int sno;
	private String sname;
	private String sadd="Odisha";
	private double fee=5000.0;
}
