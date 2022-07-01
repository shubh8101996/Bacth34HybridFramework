package com.hybrid.testclass;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hybrid.javaPageClass.DashboradPageObjectClass;
import com.hybrid.javaPageClass.LoginPageObjectClass;
import com.hybrid.javaPageClass.MainPageObjectClass;


@Listeners(com.hybrid.Utilities.ExtentListenerClass.class)
public class TC_LoginTestCase extends BaseClass {

	
	@Test(priority = 1,description = "Login Functionality Test case")
	public void Login() throws InterruptedException {

		driver.get(url);
		logger.info("url is entered");
		driver.manage().deleteAllCookies();
		logger.info("cookies deleted");

		driver.manage().window().maximize();
		logger.info("window is maximized");

		
		MainPageObjectClass m=new MainPageObjectClass(driver);
		
		m.ClickOnLoginBtn();
		logger.info("MainPage Login button is Clicked");

		
		Thread.sleep(1000);
		
		LoginPageObjectClass l=new LoginPageObjectClass(driver);
		
		l.enterCred("shubhamshedge810@gmail.com","AdminShubham@123");
		logger.info("credentials is entered");
		
		l.ClickonLogin();
		logger.info("Click on Login button");

		Thread.sleep(5000);
		
		DashboradPageObjectClass d=new DashboradPageObjectClass(driver);
		
		d.ClickOnLogOutbtn();
		logger.info("Clicked on Logout button");
		
		Thread.sleep(3000);
		
		
		
	}
	
	
}
