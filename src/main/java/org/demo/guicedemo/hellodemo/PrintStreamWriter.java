package org.demo.guicedemo.hellodemo;

import java.io.PrintStream;

public class PrintStreamWriter implements MyDestination {

	private PrintStream destination;
	
	public PrintStreamWriter(PrintStream destination) {
		super();
		this.destination = destination;
	}

	@Override
	public void write(String string) {
		destination.println(string);
	}
}
