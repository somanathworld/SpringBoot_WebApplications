package com.nt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Tourist {

	private Integer tid;
	@NonNull
	private String name;
	@NonNull
	private String city;
	@NonNull
	private String packageType;
	@NonNull
	private Double price;
}
