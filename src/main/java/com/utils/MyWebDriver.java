package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyWebDriver {
	
private static MyWebDriver instanceOfSingletonBrowserClass = null;
	
    private WebDriver driver;

    private MyWebDriver(){
		driver= new ChromeDriver();
		driver.manage().window().maximize();
    }

    public static MyWebDriver getInstanceOfSingletonBrowserClass(){
        if(instanceOfSingletonBrowserClass==null){
        	instanceOfSingletonBrowserClass = new MyWebDriver();
        }
        return instanceOfSingletonBrowserClass;
    }
    
    public WebDriver getDriver()
    {
    	return driver;
    }

}
