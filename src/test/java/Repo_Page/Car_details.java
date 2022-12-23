package Repo_Page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Iterators;

import Nallas.Nallas_demoproject.TestBase.common_function;
import Nallas.Nallas_demoproject.TestBase.testbase;
public class Car_details extends testbase
{
	@FindBy(xpath="//a/span[contains(text(),'Buy Now')]")
	public static WebElement Buynow_button;
	
	
	@FindBy(xpath="(//input[@name='zip'])[1]")
	public static WebElement EnterZip_textbox;
	
	
	@FindBy(xpath="//Select[@name='range']")
	public static WebElement range_dropdown;
	
	
	
	@FindBy(xpath="//input[@title='Model X']")
	public static WebElement model_radiobutton;
	
	@FindBy(xpath="//input[@title='New']")
	public static WebElement Inventory_radiobutton;
	//*[name()='image'][@*[contains(.,'ExtBlack')]]
	
	
	
	@FindBy(xpath="(//*[local-name()='svg']/*[local-name()='image'])[2]")
	public static WebElement Black_image;
	
	
	
	@FindBy(xpath="//select[@name='filter-sort-by']")
	public static WebElement Sortby_dropdown;
	
	
	@FindBy(xpath="//button/i[@class='filter-icon filter-icon--list']")
	public static WebElement listview_button;
	
	@FindBy(xpath="//div[@class='tds-tooltip-wrapper tds-tooltip-wrapper--inline result-price-tooltip']")
	public static WebElement tooltip_icon;
	
	@FindBy(xpath="//section[@class='result-gallery']")
	public static WebElement gallery1;
	
	@FindBy(xpath="(//div[@class='result-photos_controls result-photos-controls result-photos-navigation idp--js-carousel-navigation result-photos-navigation--dotted '])[1]")
	public static WebElement gallery;
	
	@FindBy(xpath="//div[@class='text-loader--content tds-text--center tds-o-vertical_padding--1x vehicleName-secondary-title tds-text--h6']/span")
	public static WebElement carmodel;
	
	
	
	public static String zipcode = "96145";
	public static String miles = "100";
	public static String sortby = "phl";
	
	public static String tooltip_parent = "//div[@class='financing-tooltip']";
	
	public static String tooltip_child ="/span";
	
	public static String carmodel_parent = "//section[@class='result-header']/div/h3[@class='tds-text--h4']";
	
	public static String carmodel_child = "/span";
	
	public static String keyfeature = "(//div[@class='info-block-content tds-list']/ol[@class='tds-list tds-list--unordered'])[2]/li";
	
	public static String carmode = "//div/h1/span";
	
	public static String tooltip_icon_xpath= "//div[@class='tds-tooltip-wrapper tds-tooltip-wrapper--inline result-price-tooltip']";
	
	public static String css = "label[for='checkbox-PAINT_BLACK']";
	
	public static String gallery_xpath ="(//div[@class='result-photos_controls result-photos-controls result-photos-navigation idp--js-carousel-navigation result-photos-navigation--dotted '])";
	
	public static String viewdetail_xpath ="(//button[contains(text(),'View Details')])";
	
	public static String carmodel_xpath ="//div[@class='text-loader--content tds-text--center tds-o-vertical_padding--1x vehicleName-secondary-title tds-text--h6']/span";
	
	public static String parentwindow ="";
	public static  WebDriverWait wait; 
	public Car_details()
	{
			PageFactory.initElements(driver, this);
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 wait = new WebDriverWait(driver,30);
	}
	
	
	@SuppressWarnings("static-access")
	public static void cardetail_verification() throws InterruptedException, ClassNotFoundException, SQLException
	{
		try
		{
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		
		common_function common_fn = new common_function();
		parentwindow = driver.getWindowHandle();
		Thread.sleep(6000);
		
		List<WebElement> gallary_list = driver.findElements(By.xpath(gallery_xpath));
		
		int list_size = gallary_list.size();
		
		System.out.println("size"+list_size);
		
		for(int a=1; a<list_size+1;a++)
		{
			Actions actn1 = new Actions(driver);
			
			String xpathbuilder = gallery_xpath+"["+a+"]";
			
			WebElement gallery_img = driver.findElement(By.xpath(xpathbuilder));
			common_fn.webelement_Scrollview(gallery_img);
			actn1.moveToElement(gallery_img).click().build().perform();
			//common_function common_fn = new common_function();
			//common_fn.elementclick_JS(newElement,"image click completed");
			//actn.moveToElement(gallery).perform();
			Thread.sleep(2000);
			String viewdetail_xpathbuilder = viewdetail_xpath+"["+a+"]";
			System.out.println(viewdetail_xpathbuilder);
			WebElement viewdetails_ele = driver.findElement(By.xpath(viewdetail_xpathbuilder));
			//Thread.sleep(2000);
			actn1.moveToElement(viewdetails_ele).click().build().perform();
			//Thread.sleep(2000);
			//keyfeature_insertion(keyfeature);
			
			driver.switchTo().window(parentwindow);
			//Thread.sleep(2000);
			
			
			if (a % 2 == 0) 
			{
				Actions action1 = new Actions(driver);
				for(int b=0;b<15;b++)
				{
					action1.sendKeys(Keys.chord(Keys.DOWN)).perform();
				}
			}
			
		}
		}
		catch(Exception e)
		{
         System.out.println(e.toString());
			
			log.info(e.toString());
		}
		
	}
	
	
	
	
	
	
	@SuppressWarnings("static-access")
	public static void keyfeature_insertion() throws ClassNotFoundException, SQLException, InterruptedException
	{
		try
		{
		//Thread.sleep(5000);
		System.out.println("invoke");
		String currentwindow_handle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
       
        System.out.println("window count"+allWindowHandles.size());
        
        for(String handle : allWindowHandles)
        
		{
			System.out.println("child window");
           
			if(currentwindow_handle.equalsIgnoreCase(handle))
			{
				driver.close();
			}
			else
			{
			driver.switchTo().window(handle);
			//Thread.sleep(5000);
			WebElement cr_model= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( carmodel_xpath)));
			
			String car_model = cr_model.getText();
			
			List<WebElement> keyfeature_list = new ArrayList<WebElement>();
			keyfeature_list = driver.findElements(By.xpath(keyfeature));
			int size = keyfeature_list.size();
			String Keyfeature ="";
			for(int b=1; b<size;b++)
			{
				
				String xpathbuilder = keyfeature+"["+b+"]";
				WebElement keyfeature_ele = driver.findElement(By.xpath(xpathbuilder));
				String Key_val = keyfeature_ele.getText();
				System.out.println("model " +car_model+" ketfeature" +Key_val);
				Keyfeature+=Key_val+", ";
				
			}
			dbconnection(car_model,Keyfeature);
			driver.close();
			}
		}
		}
		catch(Exception e)
		{
         System.out.println(e.toString());
			
			log.info(e.toString());
		}
		
	}
	
	
	@SuppressWarnings("static-access")
	
	public static void dbconnection(String carmodel,String keyfeautre) throws SQLException, ClassNotFoundException 
	{
		try
		{
			

			
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		String dir = System.getProperty("user.dir")+"\\Database\\Database4.accdb";
		
		System.out.println(dir);
		String databaseURL = "jdbc:ucanaccess://"+dir;
		
		
		
		Connection connection = DriverManager.getConnection(databaseURL);
		
		
		 String sql = "INSERT INTO Table1 (car_model, keyfeature) VALUES (?, ?)";
         
         PreparedStatement preparedStatement = connection.prepareStatement(sql);
         preparedStatement.setString(1, carmodel);
         preparedStatement.setString(2, keyfeautre);
       
        
         
         int row = preparedStatement.executeUpdate();
         connection.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
            
         
	}

	
	public static void gettextfromlist(String xpath, String parent) throws SQLException
	{
		
		WebElement parentElement = driver.findElement(By.xpath(parent));
		String parent_text = parentElement.getText();
		List<WebElement> list_element = driver.findElements(By.xpath(xpath));
		String element_text = "";
		for(WebElement ele:list_element)
		{
			String seperator ="* ";
			String key_value = ele.getText();
			String seperator1 =" * ";
			element_text += seperator+key_value+seperator1;
			
		}
		
		add_carkeyfeature(parent_text,element_text);
		
		
	}
	
	
	public static void add_carkeyfeature(String model_value, String keyfeature) throws SQLException 
	{
		try
		{
		
		String dir = System.getProperty("user.dir");
		String databaseURL = "jdbc:ucanaccess://"+dir+"//Database///Database4.accdb";
		Connection connection = DriverManager.getConnection(databaseURL);
		
		 String sql = "INSERT INTO Table3 (car_model, keyfeature) VALUES (?, ?)";
         
         PreparedStatement preparedStatement = connection.prepareStatement(sql);
         preparedStatement.setString(1,model_value);
         preparedStatement.setString(2, keyfeature);
         int row = preparedStatement.executeUpdate();
		}
		catch(Exception e)
		{
			
		}
         
	}

	
}
