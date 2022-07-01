package com.hybrid.testclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.hybrid.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static Logger logger;
	
    ReadConfig rr=new ReadConfig();
    
    
      String url=rr.getBaseUrl();
      String browser=rr.getBrowser();
      
      @BeforeClass
      public void setUp() {
    	   
    	  switch (browser.toLowerCase()) {
		 case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();

			break;

		default:
			driver=null;

			break;
		}
    	  
    	  
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
          logger=LogManager.getLogger("HybridFrameworkBatch34");

    	  
      }
      

     @AfterClass
     public void tearUp() {
	
	      driver.close();
	
      }
     
     
     public void captureScreenShot(WebDriver driver,String testname) throws IOException {
    	 
    	 TakesScreenshot sc=((TakesScreenshot)driver);
    	 
    	 File src=sc.getScreenshotAs(OutputType.FILE);
    	 File dest=new File(System.getProperty("user.dir") + "//Screenshot//" + testname + ".png");
    	 
    	 FileUtils.copyFile(src, dest);
    	 
    	 
     }
     
	
	
}
