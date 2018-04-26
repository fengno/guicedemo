package org.demo.guicedemo;

import java.io.PrintStream;

import org.demo.guicedemo.hellodemo.MyDestination;
import org.demo.guicedemo.hellodemo.PrintStreamWriter;
import org.demo.guicedemo.hellodemo.StringWritingApplet;

import com.google.inject.AbstractModule;

public class HelloWorldModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MyApplet.class).to(StringWritingApplet.class);
		bind(MyDestination.class).to(PrintStreamWriter.class);
		bind(PrintStream.class).toInstance(System.out);
		bind(String.class).toInstance("Hello World");
	}
}
