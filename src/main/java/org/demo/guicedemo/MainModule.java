package org.demo.guicedemo;

import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new HelloWorldModule());
		install(new PrintLineModule());
	}
}
