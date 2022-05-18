package util;

import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	public static String URL;
	static Properties prop = new Properties();
	static String proFileName = "utility/config.properties"; 
	
	
	public static String readURL() {
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(proFileName));  
	}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("URL");	
	}
	public static String readTestSuiteDirectory() {
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(proFileName));  
	}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("testSuiteDirectory");
	}
	public static String getApplicationName() {
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(proFileName));  
	}
		catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty("ApplicationName");
		}
	public static String getOS() {
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(proFileName));  
	}
		catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty("OS");
	}
	public static String getJiraURL() {
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(proFileName));  
	}
		catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty("JiraURL");
	}
	public static String getJiraUserName() {
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(proFileName));  
	}
		catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty("Emailid");
	}
	public static String getJiraTokenofpassword() {
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(proFileName));  
	}
		catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty("password");
	}
	public static String getJiraProject() {
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(proFileName));  
	}
		catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty("projectname");
	}
	public static String getJiraIssueType() {
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(proFileName));  
	}
		catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty("Issuetype");
	}
	public static String getJiraReportername() {
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(proFileName));  
	}
		catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty("Reportername");
	}
	public static String getJSONPath() {
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(proFileName));  
	}
		catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty("JSONPath");
	}
}
/*
A Thread is a very light-weighted process, or we can say the smallest part of the process that allows
 a program to operate more efficiently by running multiple tasks simultaneously.

Another benefit of using thread is that if a thread gets an exception or an error at the time of its 
execution, it doesn't affect the execution of the other threads. All the threads share a common memory 
and have their own stack, local variables and program counter. When multiple threads are executed in 
parallel at the same time, this process is known as Multithreading.


Just like a process, a thread exists in several states. 

1) New (Ready to run) --A thread is in New when it gets CPU time.

2) Running --A thread is in a Running state when it is under execution.

3) Suspended --A thread is in the Suspended state when it is temporarily inactive or under execution.
4) Blocked --A thread is in the Blocked state when it is waiting for resources.

5) Terminated--A thread comes in this state when at any given time, it halts its execution immediately.

Thread --class -- to achieve thread programming
CurrentThread()  --It returns a reference to the currently executing thread object.
getResourceasstream() --Returns an input stream for reading the specified resource. 

*/