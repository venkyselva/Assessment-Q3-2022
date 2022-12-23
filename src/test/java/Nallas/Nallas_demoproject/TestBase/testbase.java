package Nallas.Nallas_demoproject.TestBase;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class testbase 

{
	public static WebDriver driver;
	

	/** For Extended Reports */
	public static String img = "";
	public static String imgfail = "";
	public static ExtentReports extent;
	public static ExtentReports logger;
	public static ExtentTest test;
	public static String extendedhtml;
	
	
	/** variable  */
	 public static String currentdate =returnTodayDateTime("ddMMYYYY") ;
	 public static String location_chennai = "Chennai";
	 public static String attribute_value = "";
	 
	 public static String dynamicvalue =returnTodayDateTime("ddMMYYYY-hhmmss.SSS") ;
	 public static String tcid;
		
	/** report folder */
	public static String testexecution =System.getProperty("user.dir")+"\\videofile\\";
	public static String stepimage =System.getProperty("user.dir") +"\\Output_Report\\image\\" +currentdate;

	public static ScreenRecorder screenRecorder;
	
	public static String projectlink ="https://www.tesla.com";
	public static String browser ="";
	public static String testcaseid;
	public static String Execution_status;
	public static String tab_title ="";
	public static String field_text ="";
	
	public static List<String> downpayment = new ArrayList<String>();
	public static List<String> interest = new ArrayList<String>();
	public static List<String> month = new ArrayList<String>();
	public static List<String> year = new ArrayList<String>();
	public static List<String> model = new ArrayList<String>();
	public static Logger log = Logger.getLogger(testbase.class);
	
	public static String logfile =System.getProperty("user.dir")+"\\Log4j_Property\\log4j.properties";
	
	public static Recordset recrd; 
	
	
	 
	public static String returnTodayDateTime(String formate) 
	{
		DateFormat dateFormat = new SimpleDateFormat(formate);
		Date date = new Date();
		String dateformatnow = dateFormat.format(date);
		return dateformatnow;
	}

	    public static void invoke_browser(String link, String value) throws InterruptedException
	    {
	    	
	    	//extent = new ExtentReports(System.getProperty("user.dir")+"\\Output_Report\\Execution_Report\\Nallas_demo-"+dynamicvalue+".html");
	    	String path = System.getProperty("user.dir");
	    	PropertyConfigurator.configure(logfile);
	    	if(value.equalsIgnoreCase("chrome"))
	    	{
	    		String filename = returnTodayDateTime("ddMMYYYY-hhmmss");
	    		extent = new ExtentReports(System.getProperty("user.dir")+"\\Output_Report\\Execution_Report\\Nallas_demo-"+filename+".html");
	    	System.setProperty("webdriver.chrome.driver", path+"/Drivers/chromedriver.exe");
	    	ChromeOptions option = new ChromeOptions();
	    	option.addArguments("--disable-notifications");
	    	
	    	driver = new ChromeDriver(option);
	    	driver.manage().deleteAllCookies();
	    	log.info("Open Chromedriver");
	    	
	    	}
	    	else if(value.equalsIgnoreCase("firefox"))
	    	{
	    		String filename = returnTodayDateTime("ddMMYYYY-hhmmss.SSS");
	    		extent = new ExtentReports(System.getProperty("user.dir")+"\\Output_Report\\Execution_Report\\Nallas_demo-"+filename+".html");
	    		System.setProperty("webdriver.gecko.driver", path+"/Drivers/geckodriver.exe");
	    		FirefoxOptions options = new FirefoxOptions();
	    		
	    		
	    		
	    		options.setCapability("marionette", true);
	    		options.setCapability("Platform", org.openqa.selenium.Platform.ANY);

	    		 driver = new FirefoxDriver(options); //Creating an object of FirefoxDriver
	    				driver.manage().window().maximize();
	    				log.info("Open Firefox");
	    	}
	    	else if(value.equalsIgnoreCase("edge"))
	    	{
	    		String filename = returnTodayDateTime("ddMMYYYY-hhmmss.SSS");
	    		extent = new ExtentReports(System.getProperty("user.dir")+"\\Output_Report\\Execution_Report\\Nallas_demo-"+filename+".html");
	    		
	    		//System.setProperty("webdriver.ie.driver", path+"/Drivers/IEDriverServer.exe"); 
	    		System.setProperty("webdriver.edge.driver", path+"/Drivers/msedgedriver.exe");
	            
	    		// Instantiate a IEDriver class. 
	    		 driver=new EdgeDriver();
	    		 log.info("Open Edge");
	    	}
	    	driver.get(link);
	        
	         driver.manage().window().maximize();
	         log.info("Open Website"+link);
	         Thread.sleep(8000);
	         //Actions actns = new Actions(driver);
	         //actns.sendKeys(Keys.ESCAPE).perform();
	    	
	         
	    }
	    
	    
	    public static void logMessage_text(String messageToLog) {
			try {
				System.out.println(messageToLog);
				test.log(LogStatus.PASS,messageToLog);
			} catch (Exception e) {
				test.log(LogStatus.FAIL,e.toString());
			}
		}
	    
	    public static void logMessage_withScreenshot(String messageToLog) {
			try {
				System.out.println(messageToLog);
				img = capture(driver);
				test.log(LogStatus.PASS, test.addScreenCapture(img) + messageToLog);
			} catch (Exception e) {
				test.log(LogStatus.FAIL,e.toString());
			}
		}
	    
	    public static void Error_withScreenshot(String messageToLog) {
			try {
				System.out.println(messageToLog);
				img = capture(driver);
				test.log(LogStatus.ERROR, test.addScreenCapture(img) + messageToLog);
			} catch (Exception e) {
				test.log(LogStatus.FAIL,e.toString());
			}
		}
	    
	    public static void Failure_withScreenshot(String messageToLog) {
			try {
				System.out.println(messageToLog);
				img = capture(driver);
				test.log(LogStatus.FAIL, test.addScreenCapture(img) + messageToLog);
			} catch (Exception e) {
				test.log(LogStatus.FAIL,e.toString());
			}
		}
	    
	    public static String capture( WebDriver driver) throws IOException {
	    	String destinationfile = null;
	    	try
	    	{
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			String currentdate = returnTodayDateTime("ddMMYYYY");
			String timestamp = returnTodayDateTime("HHmmss");
			 destinationfile = System.getProperty("user.dir") + "\\Output_Report\\" + currentdate+"\\"+
					currentdate+ timestamp + ".png";
			File destination = new File(destinationfile);
			FileUtils.copyFile(source, destination);
			 log.info("Screenshot taken and added in destination"+destinationfile);
			
	    	}
	    	catch (Exception e) {
				test.log(LogStatus.FAIL,e.toString());
				 log.info(e.toString());
			}
	    	return destinationfile;
		}
	    
	    public static void Element_Highlight(WebElement Element) {
			try 
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
				Thread.sleep(6000);
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", Element);
				jsExecutor.executeScript("arguments[0].style.border='2px solid red'", Element); 
				img = capture(driver);
				test.log(LogStatus.PASS, test.addScreenCapture(img) + "Element identified");
				
			} catch (Exception e) 
			{
				test.log(LogStatus.FAIL, test.addScreenCapture(img) + "Element identified");
			}
		}
	    


}
