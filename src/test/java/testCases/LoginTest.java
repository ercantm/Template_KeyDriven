package testCases;

import static org.testng.Assert.assertTrue;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class LoginTest extends TestBase {
@Test
public void loginAsWorker() throws InterruptedException {
	log.debug("OTRT login Test Starting ");
driver.findElement(By.xpath("//input[@id='inputEmail3']")).sendKeys("ercan@ontherighttrack.com");

driver.findElement(By.cssSelector("#inputPassword3")).sendKeys("Amerika254");
driver.findElement(By.xpath("//input[@value='SIGN IN']")).click();
	System.out.println(OR.getProperty("EBTM_XPATH"));
	
	
	
//type("EBTM_XPATH","ercan@ontherighttrack.com");
//type("PWBTM-XPATH","Amerika254");

//click("SNBTM-XPATH");




Assert.assertTrue(isElementPresent(By.xpath("//div[@id='toast-container']")));
log.debug(" Test succesfully executed " );

 
 //Assert.assertTrue(isElementPresent(By.xpath("//i[@class='fa fa-plus']"))); 
 Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("ADD_XPATH"))));

log.debug("ADD new Quote   bottonu is found");

}



}
