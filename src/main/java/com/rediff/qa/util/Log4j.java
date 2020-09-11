package com.rediff.qa.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j {

	private static Logger log = LogManager.getLogger(Log4j.class.getName());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log.debug("this is a debug message");
		
		if(5>4) {
			log.error("this is error message");
		log.fatal("this is fatal message");
		log.info("this is info message");
		}
	}

}
