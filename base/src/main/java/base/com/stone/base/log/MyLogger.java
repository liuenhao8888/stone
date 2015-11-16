package com.stone.base.log;

import org.apache.log4j.Logger;

public class MyLogger extends Logger {

	protected static Logger log;

	protected MyLogger() {
		super("MyLogger");
	}

	protected MyLogger(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void error(Exception e) {

		e.printStackTrace();

		log.error(e.getMessage());

	}

	public static MyLogger getLogger(Class c) {
		log = Logger.getLogger(c);
		return new MyLogger();
	}

}
