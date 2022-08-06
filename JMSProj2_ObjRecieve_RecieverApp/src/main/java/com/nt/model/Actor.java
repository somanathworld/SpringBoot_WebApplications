package com.nt.model;

import java.io.Serializable;

public class Actor implements Serializable {

	private static final long serialVersionUID = 1L;

	private int actorId;
	private String actorName;
	private String actorAddrs;

	public Actor() {
		// TODO Auto-generated constructor stub
	}
	
	public Actor(int actorId, String actorName, String actorAddrs) {
		super();
		this.actorId = actorId;
		this.actorName = actorName;
		this.actorAddrs = actorAddrs;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getActorAddrs() {
		return actorAddrs;
	}

	public void setActorAddrs(String actorAddrs) {
		this.actorAddrs = actorAddrs;
	}


	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorName=" + actorName + ", actorAddrs=" + actorAddrs + "]";
	}

}
