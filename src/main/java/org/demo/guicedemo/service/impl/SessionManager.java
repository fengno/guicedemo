package org.demo.guicedemo.service.impl;

import javax.inject.Inject;

public class SessionManager {
	
	private final Long sessionId;
	
	@Inject
	public SessionManager(Long sessionId) {
		super();
		this.sessionId = sessionId;
	}

	public Long getSessionId() {
		return sessionId;
	}

}
