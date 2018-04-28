package org.demo.guicedemo;

import org.demo.guicedemo.hellodemo.PrintLineApplet;

import com.google.inject.AbstractModule;

public class PrintLineModule extends AbstractModule {

	@Override
	protected void configure() {
//		bind(MyApplet.class).annotatedWith(Names.named("println")).to(PrintLineApplet.class);

		/*MapBinder.newMapBinder(binder(), String.class, MyApplet.class).addBinding("println")
				.to(PrintLineApplet.class);*/
		Applets.register(binder()).named("println").to(PrintLineApplet.class);
	}

}
