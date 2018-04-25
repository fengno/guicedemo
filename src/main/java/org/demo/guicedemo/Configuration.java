package org.demo.guicedemo;

import org.demo.guicedemo.hellodemo.StringWritingApplet;
import org.demo.guicedemo.hellodemo.PrintStreamWriter;
import org.demo.guicedemo.hellodemo.StringProvider;

public class Configuration {

	public static MyApplet getMainApplet() {
		return new StringWritingApplet(new PrintStreamWriter(System.out), new StringProvider() {
			
			@Override
			public String get() {
				return "Hello World";
			}
		});
	}
}
