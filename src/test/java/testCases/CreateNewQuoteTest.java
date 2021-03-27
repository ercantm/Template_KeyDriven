package testCases;

import java.util.Hashtable;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	//selectcostemer.selectByIndex(0);
	
	selectcostemer.selectByVisibleText("Test");
   //select((By.xpath("//div[@class='col-sm-4 form-group inputbutton customerListDropDown float-left']//select[@class='select-dropdown ng-untouched ng-pristine ng-valid ng-star-inserted']")), "Test");
	driver.findElement(By.xpath("//input[@id='curtainCost']")).sendKeys("Test_KeyDRiven");
	
	// we will choose the Type selector 
	//WebElement typeparent=driver.findElement(By.xpath("//body/anms-root[@class='ng-tns-c0-0']/main[@class='ng-tns-c0-0']/pages[@class='ng-star-inserted']/div[@class='pages-main']/div[@class='pages-content-main']/div[@class='al-main']/div[@class='pages-content']/add-quotes[@class='ng-star-inserted']/div[@class='addNewQuoteContainer']/div[@class='row addNewQuoteSegment']/div[@class='addNewQuoteDetails']/form[@class='ng-dirty ng-valid ng-touched']/div[@class='col-sm-12 addNewQuote float-left']/div[4]"));
    //WebElement type=typeparent.findElement(By.xpath("select[@class='select-dropdown ng-valid ng-star-inserted ng-dirty ng-touched']"));
    //WebElement type=driver.findElement(By.cssSelector("select[classname=col-sm-12.float-left "));
	
	System.out.println(isElementPresent(By.cssSelector(".col-sm-12.float-left > .col-sm-4.form-group.inputbutton.curtainTypeDropDown.float-left")));
	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("(.ng-star-inserted)[1]"))));
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Select dpdown = new Select(driver.findElement(By.xpath("//body/anms-root[1]/main[1]/pages[1]/div[2]/div[2]/div[1]/div[2]/add-quotes[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/dropdrown[1]/div[1]/select[1]")));
	
	System.out.println("Dropdown has been selected!");

	dpdown.selectByIndex(1);
	
	
	// puttin pricee. 
	
driver.findElement(By.cssSelector("input[formcontrolname='includeLaborCost']")).click();

driver.findElement(By.cssSelector("#laborCost")).sendKeys("1500");
WebElement costrail=driver.findElement(By.xpath("//body/anms-root[1]/main[1]/pages[1]/div[2]/div[2]/div[1]/div[2]/add-quotes[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[4]/div[5]/input[1]"));
wait.until(ExpectedConditions.visibilityOf(costrail)).click();;
//driver.findElement(By.cssSelector("anms-root.ng-tns-c0-0:nth-child(1) main.ng-tns-c0-0 pages.ng-star-inserted div.pages-main div.pages-content-main div.al-main div.pages-content add-quotes.ng-star-inserted:nth-child(2) div.addNewQuoteContainer div.row.addNewQuoteSegment div.addNewQuoteDetails form.ng-dirty.ng-valid.ng-touched div.col-sm-12.addNewQuote.float-left:nth-child(1) div.col-sm-12.float-left:nth-child(4) div:nth-child(4) div.col-sm-4.form-group.float-left:nth-child(5) > input.ng-valid.ng-touched.ng-dirty")).click();

//driver.findElement(By.cssSelector("#custom_track_per_ft_cost_percent")).sendKeys("8.65");
	


// creatin room trak 

driver.findElement(By.cssSelector("#quantity")).sendKeys("2");
driver.findElement(By.cssSelector("#area_floor")).sendKeys("ShowerRoom");
driver.findElement(By.xpath("//input[@id='room']")).sendKeys("124B");
driver.findElement(By.cssSelector("#track_designation")).sendKeys("124-BCS");
driver.findElement(By.xpath("//input[@id='ceiling_height_feet']")).sendKeys("9");

driver.findElement(By.xpath("//input[@id='ceiling_height_inches']")).sendKeys("6");
driver.findElement(By.xpath("//input[@formcontrolname='ninety_degree_wall_touches']")).click();

//selecting connection Type. 

WebElement conect=driver.findElement(By.cssSelector("body > anms-root:nth-child(1) > main:nth-child(1) > pages:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > add-quotes:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > screen2:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > add-track-details:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(8) > dropdrown:nth-child(2) > div:nth-child(1) > select:nth-child(1)"));
new Select(conect).selectByValue("1: ACT");
WebElement ShapeType=driver.findElement(By.xpath("//div[@class='col-sm-3 form-group fabricPatternListDropDown float-left']//select[@class='select-dropdown ng-untouched ng-pristine ng-valid ng-star-inserted']"));
new Select(ShapeType).selectByValue("1: 1 Curve");
driver.findElement(By.xpath("//input[@id='first_feet']")).sendKeys("12");
driver.findElement(By.xpath("//input[@id='first_inches']")).sendKeys("6");
driver.findElement(By.xpath("//input[@id='second_feet']")).sendKeys("4");
driver.findElement(By.xpath("//input[@id='second_inches']")).sendKeys("8");
WebElement Curvetype=driver.findElement(By.xpath("//body/anms-root[1]/main[1]/pages[1]/div[2]/div[2]/div[1]/div[2]/add-quotes[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/screen2[1]/div[1]/div[1]/div[1]/div[1]/add-track-details[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[13]/div[1]/dropdrown[1]/div[1]/select[1]"));
new Select(Curvetype).selectByValue("2: 90° 1 ft. Radius Bend");
Assert.assertTrue(isElementPresent(By.xpath("//input[@value='Add Track']")));









	}

	
}