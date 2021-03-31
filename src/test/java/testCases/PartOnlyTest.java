package testCases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.TestBase;

import pages.PartOnly;
import utilities.TestUtil;

public class PartOnlyTest extends TestBase {
	PartOnly p;

	@Test()
	public void partOnlyTest() throws InterruptedException {
		
		
		
		p=new PartOnly(TestBase.driver);
		click(p.quotebtm());
		waitClickable(p.addbtm());
		click(p.addbtm());
		waitVisible(p.chooseCostemer());
		selectbyValue(p.chooseCostemer(), "219: Test");
		type(p.chooseProjectName(),"PageObjectDataDriven");
		Assert.assertTrue(isElementPresent(By.cssSelector(
				".col-sm-12.float-left > .col-sm-4.form-group.inputbutton.curtainTypeDropDown.float-left")));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//WebElement dp = driver.findElement(By.xpath(
		//		"//body/anms-root[1]/main[1]/pages[1]/div[2]/div[2]/div[1]/div[2]/add-quotes[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/dropdrown[1]/div[1]/select[1]"));
		//selectbyIndex(dp, 2);
		Assert.assertTrue(isElementPresent(p.type));
		selectbyValue(p.chooseProjectType(),"2: Parts Only");
		click(p.addcurve());
		selectbyIndex(p.chooseurve(), 2);
		type(p.AddCurvequantity(), "10");
		click(p.addedcurve());
		waitVisible(p.verifyCurve());
		Assert.assertTrue(isElementPresent(p.verify));
		

	}
}