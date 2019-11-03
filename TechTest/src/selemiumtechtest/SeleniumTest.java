package selemiumtechtest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class SeleniumTest {
	public static void main(String[] args) {
		//Setting driver properties this is normally done inside the framework
		System.setProperty("webdriver.chrome.driver","C:\\Temp\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String resultMessage = "";
		String ecpectedResult = "You clicked: Ok";
		
		//Setting up wait code
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)) 			
				.ignoring(NoSuchElementException.class);				

		// Load Url and make the page full screen
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		// Normally I would Use page objects but I have been sick and am out of time
		// Navigate to Javascript alert and click the JS confirm button
		driver.findElement(By.linkText("JavaScript Alerts")).click();
		driver.findElement(By.cssSelector("li:nth-child(2) button")).click();
		
		//Wait Until alert is Present then switch to the alert
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

		//assert result - I do not have testNG or junit installed so i will compare strings
		//otherwise I would assert
		resultMessage = driver.findElement(By.id("result")).getText();
		
        if (resultMessage.contentEquals(ecpectedResult)){
            System.out.println("Test Passed! The following result was displayed: " + resultMessage);
        } else {
            System.out.println("Test Failed The following result was displayed: " + resultMessage);
        }
	
		driver.quit();

	}

}
