package org.demo.guicedemo;

import java.io.PrintStream;
import java.util.List;

import org.demo.guicedemo.hellodemo.MyDestination;
import org.demo.guicedemo.hellodemo.Output;
import org.demo.guicedemo.hellodemo.PrintStreamWriter;
import org.demo.guicedemo.hellodemo.StringWritingApplet;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class HelloWorldModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MyApplet.class).to(StringWritingApplet.class);
		bind(MyDestination.class).to(PrintStreamWriter.class);
		bind(PrintStream.class).toInstance(System.out);
//		bind(String.class).annotatedWith(Output.class).toInstance("Hello World");
	}
	
	@Provides @Output String getOutputString(
			@Args List<String> args) {
		return args.get(0);
	}
}
