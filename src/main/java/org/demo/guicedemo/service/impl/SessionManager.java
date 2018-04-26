package org.demo.guicedemo.service.impl;

import javax.inject.Inject;

import com.google.inject.Provider;

public class SessionManager {
	
	private final Provider<Long> sessionIdProvider;
	
	@Inject
	public SessionManager(Provider<Long> sessionIdProvider) {
		super();
		this.sessionIdProvider = sessionIdProvider;
	}

	public Long getSessionId() {
		return sessionIdProvider.get();
	}

}
