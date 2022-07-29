package com.nt.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Employee {

	private Integer eno;
	private String ename;
	private List<Company> companiesList;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime joinDate;
	private List<Map<String, Long>> familyIds;
}
