package com.Amazon_demo.tests;


import org.testng.annotations.Test;
import com.Amazon_demo.pages.AmazondemoPage;
import utility.TestBase;

public class AmazonDemoTest extends TestBase{
	//WebDriver driver;
	AmazondemoPage amazondemoobj;
	
	
	//@Test
	public void initElements() throws Exception{
		 
		//PageFactory.initElements(driver, amazondemoobj);
		//AmazondemoPage amazondemoobj=PageFactory.initElements(driver, AmazondemoPage.class);
	}
	
	@Test
	public void Test1() throws Exception{
		System.out.println("check1");
		 amazondemoobj=new AmazondemoPage(driver);
		amazondemoobj.AmazonPagedemo_test();
		System.out.println("check2");
	}
	
	@Test
	public void Test2() throws Exception {
		System.out.println("check3");
		amazondemoobj.AmazonSignout();
		System.out.println("check4");
	}
}
