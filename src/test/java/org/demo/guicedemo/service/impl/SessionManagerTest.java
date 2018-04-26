package org.demo.guicedemo.service.impl;

import static org.junit.Assert.assertNotEquals;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;

public class SessionManagerTest {
	@Inject SessionManager sessionManager;
	
	@Before public void setUp() {
		Guice.createInjector(new ServerModule()).injectMembers(this);
	}

	@Test
	public void testGetSessionId() throws InterruptedException {
		Long sessionId = sessionManager.getSessionId();
		Thread.sleep(1000);
		Long sessionId2 = sessionManager.getSessionId();
		assertNotEquals(sessionId2.longValue(), sessionId.longValue());
	}

}
