package com.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\java\\com\\feature\\amazon.feature",	
glue="com.stepdefinition",monochrome = true,plugin ={"pretty","html:Report/HtmlReport.html"})

public class AmazonRunner {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sathish\\eclipse-workspace\\amazonproject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public static void tearDown() {
		driver.close();
	}

}
//monochrome=true,strict=true,plugin={"pretty","html:report/cucumber-html-report",
//"jason","report/cucumber.jason","junit","report/cucumber.xml"})//plugin="json:Dracarys/Amazon.json"