package com.nt.model;


public class Customer {

	private int id;
	private String name;
	private String addrs;
	private Float billAmt;
	
	@Override
	public String toString() {
		return id+" "+name+" "+addrs+" "+billAmt;
	}
}
