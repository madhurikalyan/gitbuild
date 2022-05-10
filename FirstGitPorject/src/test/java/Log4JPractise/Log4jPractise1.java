package Log4JPractise;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jPractise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger log= org.apache.log4j.Logger.getLogger("Log4jPractise1.class");
		PropertyConfigurator.configure("D:\\Practise\\FrameWorkDeisgnsPractiseWorkSpace\\SumanthNewSelenium\\src\\Log4JPractise\\log4j.properties");
		
		log.debug("**Hi Log msg -1");
		log.debug("Hi Log msg -2");
		
		log.info("Hi Log info msg-3");
		log.info("Hi Log info msg-4");
		
		log.error("Log erro-1");
		log.error("Log erro-2");
		
		log.info("appended");
		
		System.out.println("ends");

	}

}
