package Nallas.Nallas_demoproject;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import Nallas.Nallas_demoproject.Testcase;
import Nallas.Nallas_demoproject.TestBase.testbase;



public class Testcase_Execution extends testbase
{
	
	// Change the value to run in different browser: firefox, edge
	private static String  browser_name = "Chrome";
	
	@BeforeClass
	public void beforesuite() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InterruptedException{
		
		//String date = returnTodayDateTime("ddMMYYYY-hhmmss");
   	    // extent = new ExtentReports(System.getProperty("user.dir")+"\\outputreport\\Execution_report-"+date+".html");
		
		
	}
	
 
	
	@BeforeTest
	public void openBrowser() throws InterruptedException 
		 {
		   System.out.println("br"+browser_name);
		   
		   // projectlink need to be update in testbase file
			invoke_browser(projectlink,browser_name);
		 }
	
	
	/// To find array index which matched for given integer
	@SuppressWarnings("static-access")
	@Test
	public static void TS01_TC_001() throws ClassNotFoundException, InterruptedException, SQLException
	{
		try
		{
		tcid = Thread.currentThread().getStackTrace()[1].getMethodName();
  		test = extent.startTest(tcid);
		//input array
		int[] int_array = {1,2,4,4,5,6,7,8,9,10};
		
		// integer value to compare in array
		int sum = 16;
		Testcase testcase_definition = new Testcase();
		testcase_definition.TC_01(int_array,sum);
		}
		catch(Exception e) 
		{			
			test.log(LogStatus.FAIL, "Test Failed");
		}
		
	}
	
	
	@SuppressWarnings("static-access")
	@Parameters ("BrowserType")
	@Test
	//** open web site and verify tab name to confirm proper page was loaded. //
	public static void TS_001_TC_02() throws Exception {
		try
		{
		
		 tcid = Thread.currentThread().getStackTrace()[1].getMethodName();
	   	  test = extent.startTest(tcid);

		
			Testcase tc = new Testcase();
			tc.TC_02();
	
	
			test.log(LogStatus.PASS, "Testcase ID: "+tcid+" completed  -Status: Pass");
		}
		catch(Exception e) 
		{			
			test.log(LogStatus.FAIL, "Test Failed");
		}
		
		
    }
    
    
   
   
   @AfterMethod
	public void getResult(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getThrowable());
			test.log(LogStatus.FAIL, "Test failed");
		}

		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, "Test Pass");
		}

		if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Skip");
		}
		
	}

	@AfterTest
	public void endtest() {
		extent.endTest(test);
		driver.quit();
		extent.flush();
		dynamicvalue = "";
	}


}
