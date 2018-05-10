package com.bti.inventory.dto;

public class UserSessionDto {

	private static final long serialVersionUID = 1L;

	public UserSessionDto(String sessionId, Integer currentUser, String compnayTenantId) {
		super();
		this.sessionId = sessionId;
		this.currentUser = currentUser;
		this.compnayTenantId = compnayTenantId;
	}
	
	

	public UserSessionDto() {
		// TODO Auto-generated constructor stub
	}



	private String sessionId;
	private Integer currentUser;

	private String compnayTenantId;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Integer getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Integer currentUser) {
		this.currentUser = currentUser;
	}

	public String getCompnayTenantId() {
		return compnayTenantId;
	}

	public void setCompnayTenantId(String compnayTenantId) {
		this.compnayTenantId = compnayTenantId;
	}

}
