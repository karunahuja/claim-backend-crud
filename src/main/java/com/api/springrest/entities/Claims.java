package com.api.springrest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Claims {
	
	@Id
	private int id;
	private int claimNumber;
	private String claimType;

	private String creationDate;
	
	private String createdBy;
	
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(int claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Claims() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Claims(int id, int claimNumber, String claimType, String creationDate, String createdBy, String status) {
		super();
		this.id = id;
		this.claimNumber = claimNumber;
		this.claimType = claimType;
		this.creationDate = creationDate;
		this.createdBy = createdBy;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Claims [id=" + id + ", claimNumber=" + claimNumber + ", claimType=" + claimType + ", creationDate="
				+ creationDate + ", createdBy=" + createdBy + ", status=" + status + "]";
	}


}
