package listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.MonitoringMail;
import utilities.TestConfig;
import utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener,ISuiteListener {

	public void onTestStart(ITestResult result) {
	
		
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName().toString()+"   test is succefully tested");
		test.log(LogStatus.PASS, result.getName().toUpperCase()+"  Passed");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.eacape-out","false");// this help to show htm code in index,htm report 
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(LogStatus.SKIP, result.getName().toUpperCase()+ "   Failled with this exception:   "+ result.getThrowable().toString().trim());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		Reporter.log( result.getMethod().getMethodName().toString()+ " failed and capturing screanshot");
		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height=200 width=200></img></a>");
		
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName().toString()+"   test is  skipped");
		test.log(LogStatus.SKIP, result.getName().toUpperCase()+ "   skipped ");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		test = rep.startTest(context.getName().toUpperCase());
		
	}

	
	public void onStart(ISuite suite) {
		
	}

	
	public void onFinish(ISuite suite) {
//		MonitoringMail mail = new MonitoringMail();
//		 
//		try {
//			TestConfig.messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
//					+ ":8080/job/DataDrivenLiveProject/Extent_Reports/";
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		try {
//			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject,TestConfig.messageBody);
//		} catch (AddressException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	public void onFinish(ITestContext context) {

		
		
	}

}
