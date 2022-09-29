package com.stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.runner.AmazonRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import task1.amazonproject.xlsxread;

public class amazonstep {

	public WebDriver driver = AmazonRunner.driver;
	public static String expectedDropDownValue;
	public static String expectedInput;

	@Given("^user Launch Application Url$")
	public void user_Launch_Application_Url() throws Throwable {
		driver.get("https://www.amazon.in/");
	}

	@When("^user click the dropdown options$")
	public void user_click_the_dropdown_options() throws Throwable {
		expectedDropDownValue = xlsxread.datafromexcel("amazon", 0, 0);

		WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

		Select s = new Select(dropDown);
		List<WebElement> op = s.getOptions();

		for (int i = 0; i < op.size(); i++) {
			String actualDDValue = op.get(i).getText();
			if (expectedDropDownValue.equals(actualDDValue)) {

				s.selectByVisibleText(expectedDropDownValue);

			}
		}

	}

	@When("^user enter the product$")
	public void user_enter_the_product() throws Throwable {
		expectedInput = xlsxread.datafromexcel("amazon", 0, 1);
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys(expectedInput);
		Thread.sleep(2000);
		List<WebElement> sugesstions = driver
				.findElements(By.xpath("//div[@class='nav-issFlyout nav-flyout']/div/div"));
		for (int i = 1; i < sugesstions.size(); i++) {
			WebElement e = driver
					.findElement(By.xpath("//div[@class='nav-issFlyout nav-flyout']/div/div[" + i + "]/div/div"));
			String te = e.getText();
			if (expectedInput.equalsIgnoreCase(te)) {
				e.click();
				break;
			}

		}

	}

	@Then("^select required suggestions$")
	public void select_required_suggestions() throws Throwable {
		java.util.List<WebElement> moreresult = driver.findElements(
				By.xpath("//span[text()='RESULTS']/following::div[@data-component-type='s-search-result']"));
		int size = moreresult.size();
		System.out.println("the number of products on the results is" + size);

	}

}
