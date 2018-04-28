package org.demo.guicedemo;

import com.google.inject.Guice;
import com.google.inject.Key;
import com.google.inject.name.Names;

/**
 * Hello world!
 *
 */
public class App {
	/**
	 * bootstrap: parse command line set up environment kick off main logic
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MyApplet mainapplet = Guice.createInjector(new MainModule(), new CommandLineModule(args))
				.getInstance(Key.get(MyApplet.class, Names.named(args[0])));
		mainapplet.run();
	}

}
