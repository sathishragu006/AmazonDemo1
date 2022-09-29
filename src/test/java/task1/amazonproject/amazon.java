package task1.amazonproject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class amazon {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sathish\\eclipse-workspace\\amazonproject\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String expectedDropDownValue = xlsxread.datafromexcel("amazon", 0, 0);
		String expectedInput = xlsxread.datafromexcel("amazon", 0, 1);

		WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

		Select s = new Select(dropDown);
		List<WebElement> op = s.getOptions();

		for (int i = 0; i < op.size(); i++) {
			String actualDDValue = op.get(i).getText();
			if (expectedDropDownValue.equals(actualDDValue)) {

				s.selectByVisibleText(expectedDropDownValue);

			}
		}
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
		java.util.List<WebElement> moreresult = driver.findElements(
				By.xpath("//span[text()='RESULTS']/following::div[@data-component-type='s-search-result']"));
		int size = moreresult.size();
		System.out.println("the number of products on the results is" + size);

	}

}