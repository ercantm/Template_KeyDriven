package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.TestBase;

public class LoginTest extends TestBase {
	@Test
	public void loginAsWorker() throws InterruptedException {
		type(By.xpath("//input[@id='inputEmail3']"), "ercan@ontherighttrack.com");

		Reporter.log(" valid email is entered");
		type(By.cssSelector("#inputPassword3"), "Amerika254");
		Reporter.log("valid passwords is entering");
		click(By.xpath("//input[@value='SIGN IN']"));
		Reporter.log("Succefully entering main page.");
		Assert.assertTrue(isElementPresent(By.xpath("//div[@id='toast-container']")));

		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("ADD_XPATH"))));

	}

}
