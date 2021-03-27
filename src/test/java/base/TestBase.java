package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

//import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;

public class TestBase {

	private static final String False = null;
	/*
	 * webdriver propertiresd logs extentreports DP Excel Mail
	 * 
	 * 
	 */
	public static String browser;
	public static WebDriver driver;
	public static Properties config;
	public static Properties OR;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel= new ExcelReader("C:\\Users\\ercan\\Documents\\workspaces\\eclipse-ide-for-java-developers\\Teplate1\\src\\test\\resources\\excel\\data.xlsx");
   public static WebDriverWait wait;
	@SuppressWarnings("deprecation")
	@BeforeSuite

	public void setUP() throws IOException {
		config = new Properties();
		OR = new Properties();
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
        log.debug(" file are lounching");
		FileInputStream fis = new FileInputStream(f);
		config.load(fis);

		File f2 = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		fis = new FileInputStream(f2);
		OR.load(fis);

		if (System.getenv("browser") != null && (!System.getenv("browser").isEmpty())) {
			browser = System.getenv("browser");

		}

		else {
			browser = config.getProperty("browser");
		}

		config.setProperty("browser", browser);

		if (browser.toString().equalsIgnoreCase("firefox")) {
			// System.setProperty("webdriver.gecko.driver",
			// "C:\\Users\\ercan\\Driver\\Gecodriver\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			FirefoxProfile customProfile = new FirefoxProfile();
			customProfile.setPreference("dom.disable_beforeunload", true);
			// customProfile.set_preference("dom.disable_open_during_load", False);
			driver = new FirefoxDriver((Capabilities) customProfile);
			// driver = new FirefoxDriver();
			log.debug(" firefox starting");
		}
		if (browser.toString().equalsIgnoreCase("ei")) {
			// log.debug("inter explorer is startting ");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			WebDriverManager.iedriver().setup();
			// System.setProperty("webdriver.ie.driver",
			// "C:\\Users\\ercan\\Driver\\IEDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
			log.debug(" Internet Explorer  starting");
		}
		if (browser.toString().equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("--disable-popup-blocking");
			//DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			//driver = new ChromeDriver(capabilities);

			// System.setProperty("webdriver.chrome.driver",
			// "C:\\Users\\ercan\\Driver\\Chromedriver\\chromedriver.exe");
			 driver = new ChromeDriver();
			 log.debug(" Crome is  starting");
		}
		if (browser.toString().equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			// System.setProperty("webdriver.ei.driver",
			// "C:\\Users\\ercan\\Driver\\Edge\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();

		}
		if (browser.toString().equalsIgnoreCase("opera")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			OperaOptions options = new OperaOptions();
			options.setBinary("C:\\Users\\ercan\\AppData\\Local\\Programs\\Opera\\72.0.3815.18\\Opera.exe");
			capabilities.setCapability(OperaOptions.CAPABILITY, options);
			WebDriverManager.operadriver().setup();
			// System.setProperty("webdriver.opera.driver",
			// "C:\\Users\\ercan\\Driver\\OperaDriver\\operadriver.exe");
			driver = new OperaDriver();

		}
		driver.get(config.getProperty("testsiteurl"));
		log.debug("Test URl is lauching" );
		driver.manage().window().maximize();
		log.debug(" windows geting full screan get implemtting implicit wait ");
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")),
				TimeUnit.SECONDS);
		wait=new WebDriverWait(driver,15);

	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}
		log.debug(" Test execustion completed");
	}

	public static void type(String location, String value) {
		if (location.endsWith("CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(location))).sendKeys(value);
		} else if (location.endsWith("XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(location))).sendKeys(value);
		} else if (location.endsWith("ID")) {
			driver.findElement(By.id(OR.getProperty(location))).sendKeys(value);
		}
		// test.log(LogStatus.INFO, "typing in this : " + location + " enter value as
		// the " + value);

	}

	public static void click(String location) {
		if (location.endsWith("CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(location))).click();
		}

		else if (location.endsWith("XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(location))).click();
		} else if (location.endsWith("ID")) {
			driver.findElement(By.id(OR.getProperty(location))).click();
		}
		// test.log(LogStatus.INFO, "Clicking on: " + location);

	}
	public static boolean isElementPresent(By by) {

		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {
         System.out.println(e.getMessage());
			return false;
		}

	}
	@DataProvider(name = "DP1")
	public Object[][] getData() {
		Object[][] data = new Object[17][1];
		return data;

	}

}
