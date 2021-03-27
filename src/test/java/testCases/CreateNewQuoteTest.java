package testCases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.TestBase;

public class CreateNewQuoteTest extends TestBase {
	//@Test(dataProviderClass = utilities.TestUtil.class, dataProvider = "dp")
//public void CurtainTrackOnly(Hashtable<String,String> data) throws InterruptedException {
	@Test
	public void CurtainTrackOnly() {
		driver.findElement(By.xpath("//input[@id='inputEmail3']")).sendKeys("ercan@ontherighttrack.com");

		driver.findElement(By.cssSelector("#inputPassword3")).sendKeys("Amerika254");
		driver.findElement(By.xpath("//input[@value='SIGN IN']")).click();
	driver.findElement(By.xpath("//span[normalize-space()='Quotes']")).click();
	driver.findElement(By.xpath("//i[@class='fa fa-plus']")).click();
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='col-sm-4 form-group inputbutton customerListDropDown float-left']//select[@class='select-dropdown ng-untouched ng-pristine ng-valid ng-star-inserted']"))));
	Select selectcostemer= new Select(driver.findElement(By.xpath("//div[@class='col-sm-4 form-group inputbutton customerListDropDown float-left']//select[@class='select-dropdown ng-untouched ng-pristine ng-valid ng-star-inserted']")));
	selectcostemer.selectByIndex(0);
	
	
	}

	
}