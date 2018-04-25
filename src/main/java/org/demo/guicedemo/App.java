package org.demo.guicedemo;

/**
 * Hello world!
 *
 */
public class App {
	/**
	 * bootstrap:
	 * parse command line
	 * set up environment
	 * kick off main logic
	 * @param args
	 */
	public static void main(String[] args) {
		MyApplet mainapplet = Configuration.getMainApplet();
		mainapplet.run();
	}
}
