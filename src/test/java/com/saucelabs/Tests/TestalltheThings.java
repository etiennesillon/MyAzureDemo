package com.saucelabs.Tests;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;

public class TestalltheThings extends TestBase {
	
	/*********************************************************************/

    private static String APPNAME = "Things", USERNAME = "adm", PASSWD = "pwd";
    
	/*********************************************************************/

    @org.testng.annotations.Test(dataProvider = "hardCodedBrowsers")
    public void loginTest(String browser, String version, String os, Method method) throws MalformedURLException, InvalidElementStateException, UnexpectedException {
    	
        createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        
        annotate("Visiting Login page...");
        driver.navigate().to("http://localhost:8080/ModelWebv4.0/");

        driver.findElement(By.name("appl")).sendKeys(APPNAME);
        driver.findElement(By.name("userid")).sendKeys(USERNAME);
        driver.findElement(By.name("passwd")).sendKeys(PASSWD);

        annotate("Login in page...");
        driver.findElement(By.cssSelector("[type='submit']")).click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
    } 

}
