package org.demo.guicedemo.hellodemo;

import org.demo.guicedemo.MyApplet;

public class StringWritingApplet implements MyApplet {

	private MyDestination destination;
	private StringProvider stringProvider;
	
	public StringWritingApplet(MyDestination destination, StringProvider stringProvider) {
		super();
		this.destination = destination;
		this.stringProvider = stringProvider;
	}

	private void writeString() {
		destination.write(stringProvider.get());
	}

	public void run() {
		writeString();
	}
}
