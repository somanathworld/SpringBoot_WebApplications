package com.nt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class HumanActivities {
	@Id
	private String hobbies;
}
