package Repo_Page;

import java.awt.Window;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Nallas.Nallas_demoproject.TestBase.common_function;
import Nallas.Nallas_demoproject.TestBase.testbase;
public class Car_Inventory extends testbase
{
	private static final long timeout = 0;


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
	public static WebElement gallery;
	
	
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
	
	public static String gallery_xpath ="//section[@class='result-gallery']";
	
	public Car_Inventory()
	{
			PageFactory.initElements(driver, this);
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver,30);
	}
	
	
	@SuppressWarnings("static-access")
	public static void search_function() throws InterruptedException
	{
		try
		{
		common_function common_fn = new common_function();
		
		common_fn.elementclick(Buynow_button,"Buy now button Click action completed");
		
		//common_fn.webelement_Scrollview(Black_image);
		common_fn.elementclick_withclear(EnterZip_textbox,"Zipcode field Click action completed");
		
		common_fn.webelement_setnull(EnterZip_textbox);
		
		
		common_fn.sendkeys_onebyone(zipcode,"Zipcode value added successfully "+"Zipcode value :"+zipcode);
		
		
		//common_fn.elementclick_withclear(EnterZip_textbox,"Zipcode field Click action completed");
		//common_fn.sendkeys(zipcode,"Zipcode value added successfully "+"Zipcode value :"+zipcode);
		
		common_fn.Convert_to_selectelement(range_dropdown,miles,"mile option selection completed"+"Selected value "+miles);
		
		
		common_fn.elementclick_JS(model_radiobutton,"Model selection process completed");
		
		
		common_fn.elementclick(Inventory_radiobutton,"Inventory selection process completed");
		
		//common_fn.elementclick_JS(Black_image,"Exterior Color selection completed"+"Selected color: Black");
		
		common_fn.elementclick(Sortby_dropdown,"Sort by Click action completed");
		
		common_fn.Convert_to_selectelement(Sortby_dropdown,sortby,"Sortby option selection completed"+"Selected value "+sortby);
		
		//common_fn.elementclick(listview_button,"List view button Click action completed");
		
	   }
	   catch (Exception e)
	    {
		Error_withScreenshot(e.toString());
		log.info(e.toString());
	     }
	
	}
	
	public static void gettext_parent() throws InterruptedException
	{
       //gettext_using_parentelement(carmodel_parent,carmodel_child,"2");
		
		gettext_using_parentelement(tooltip_icon_xpath,tooltip_parent,tooltip_child,"3");
		System.out.println(year.size());
		
		System.out.println(carmodel_parent.length());
	}
	
	
	@SuppressWarnings("static-access")
	public static void gettooltip() throws InterruptedException, ClassNotFoundException, SQLException
	{
		try
		{
		
		List<WebElement> tooltip_list = driver.findElements(By.xpath(tooltip_icon_xpath));
		
		Thread.sleep(8000);
		int list_size = tooltip_list.size();
		System.out.println("fimal output"+list_size);
		
		for(int a=1; a<list_size;a++)
		{
		Thread.sleep(4000);
		WebElement icon = driver.findElement(By.xpath("(//div[@class='tds-tooltip-wrapper tds-tooltip-wrapper--inline result-price-tooltip'])["+a+"]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(icon).click().build().perform();
		
		Thread.sleep(4000);
		WebElement downpayment = driver.findElement(By.xpath("(//div[@class='financing-tooltip'])["+a+"]/span[1]"));
		WebElement interest = driver.findElement(By.xpath("(//div[@class='financing-tooltip'])["+a+"]/span[2]"));
		WebElement month = driver.findElement(By.xpath("(//div[@class='financing-tooltip'])["+a+"]/span[3]"));
		
	
		String dw_payment = downpayment.getText();
		String interest_gettext = interest.getText();
		String month_gettext = month.getText();
		log.info("Data added in databased:"+ "downpayment "+ dw_payment +" " +" interest: "+ interest_gettext+ " month: "+month_gettext );
		Thread.sleep(2000);
		dbconnection(dw_payment,interest_gettext,month_gettext);
		System.out.println("fimal output"+dw_payment+interest_gettext+month_gettext);
		logMessage_withScreenshot("Tool Tip added in database"+"downpayment "+ dw_payment +" " +" interest: "+ interest_gettext+ " month: "+month_gettext );
		Thread.sleep(4000);
		if (a % 2 == 0) 
		{
			Actions action1 = new Actions(driver);
			for(int b=0;b<20;b++)
			{
				action1.sendKeys(Keys.chord(Keys.DOWN)).perform();
			}
		}
		
		}
		
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			log.info(e.toString());
			
		}
		
	}
	
	
	@SuppressWarnings("static-access")
	public static void gettext_using_parentelement(String parenttag, String tooltip,String tooltipchild,String fieldcount) throws InterruptedException
	{
		try
		{
		 System.out.println("parent xpath  "+parenttag);
		common_function common_fn = new common_function();
		
		Thread.sleep(5000);
	   List<WebElement> parentElement = driver.findElements(By.xpath(parenttag));
	   List<WebElement> parentElement_Webelement = new ArrayList<WebElement>();
	   System.out.println("list size"+parentElement.size());
	   int elementcount=1;
	   //WebElement tooltip_icon;
	   int tooltip_incrementor=1;
	   for(int a=0;a<parentElement.size();a++)
	   {
		   //Thread.sleep(5000);
		   
           String tooltipxpth_builder = "("+parenttag+")"+"["+tooltip_incrementor+"]";
		   
           WebElement tooltip_icon = driver.findElement(By.xpath(tooltipxpth_builder));
           common_fn.webelement_Scrollview(tooltip_icon);
           Actions action = new Actions(driver);
			action.moveToElement(tooltip_icon).build().perform();
           Thread.sleep(4000);
			String parentxpth_builder = "("+tooltip+")["+tooltip_incrementor+"]"+tooltipchild+"[1]";
			   String parentxpth_builder2 = "("+tooltip+")["+tooltip_incrementor+"]"+tooltipchild+"[2]";
			   String parentxpth_builder3 = "("+tooltip+")["+tooltip_incrementor+"]"+tooltipchild+"[3]";
			   
			   WebElement downpayment_ele = driver.findElement(By.xpath(parentxpth_builder));
			   WebElement interest_ele = driver.findElement(By.xpath(parentxpth_builder2));
			   WebElement month_ele = driver.findElement(By.xpath(parentxpth_builder3));
			  Thread.sleep(3000);
			   System.out.println("Switch enabled");
			   String val_1 = downpayment_ele.getText();
			   String val_2 = interest_ele.getText();
			   String val_3 = month_ele.getText();
			   System.out.println(val_1+"check"+val_2+"check"+val_3);
		       downpayment.add(val_1);
		       interest.add(val_2);
		       month.add(val_3);
		       dbconnection(val_1,val_2,val_3);
			
           parentElement_Webelement.add(tooltip_icon);
           tooltip_incrementor++;
		   
	   }
	   System.out.println("Webelement list added");
	   
	   for(int a=0;a<parentElement.size();a++)
	   {
		    WebElement final_parent = parentElement_Webelement.get(a);
		    common_fn.webelement_Scrollview(final_parent);
			   Actions action = new Actions(driver);
				action.moveToElement(final_parent).build().perform();
				//Thread.sleep(3000);
		   String parentxpth_builder = "("+tooltip+")["+elementcount+"]"+tooltipchild+"[1]";
		   String parentxpth_builder2 = "("+tooltip+")["+elementcount+"]"+tooltipchild+"[2]";
		   String parentxpth_builder3 = "("+tooltip+")["+elementcount+"]"+tooltipchild+"[3]";
		   
		   System.out.println("parent xpath  "+parentxpth_builder);
		   
		   switch(fieldcount)
		   {
		   
		   case "3":
			   
			   WebElement downpayment_ele = driver.findElement(By.xpath(parentxpth_builder));
			   WebElement interest_ele = driver.findElement(By.xpath(parentxpth_builder2));
			   WebElement month_ele = driver.findElement(By.xpath(parentxpth_builder3));
			  //Thread.sleep(3000);
			   System.out.println("Switch enabled");
			   String val_1 = downpayment_ele.getText();
			   String val_2 = interest_ele.getText();
			   String val_3 = month_ele.getText();
			   System.out.println(val_1+"check"+val_2+"check"+val_3);
		       downpayment.add(val_1);
		       interest.add(val_2);
		       month.add(val_3);
		       dbconnection(val_1,val_2,val_3);
		        break;
		   
		   case "2":
			   List<WebElement> childlist1 = driver.findElements(By.xpath(parenttag));
			   Actions action2 = new Actions(driver);
			   System.out.println("Switch enabled");
			   action2.moveToElement(childlist1.get(0)).perform();
			   String val1 = childlist1.get(0).getText();
			   String val2 = childlist1.get(1).getText();
			   System.out.println(val1+"check"+val2);
			   year.add(childlist1.get(0).getText());
			   model.add(childlist1.get(1).getText());
		     break;
		    
		   }
		   
		   elementcount++;
		   
	   }
		}
	   catch(Exception e)
	   {
		   log.info(e.toString());
		  
	   }
	   
	}
	
	public static void dbconnection(String val1, String val2,String val3) throws SQLException, ClassNotFoundException 
	{
		try
		{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		String directory = System.getProperty("user.dir")+"\\Database\\Database4.accdb";
		System.out.println(directory);
		String databaseURL = "jdbc:ucanaccess://"+directory;
		
		Connection connection = DriverManager.getConnection(databaseURL);
		
		 String sql = "INSERT INTO Table2 (downpayment, interest, month) VALUES (?, ?, ?)";
         
         PreparedStatement preparedStatement = connection.prepareStatement(sql);
         preparedStatement.setString(1, val1);
         preparedStatement.setString(2, val2);
         preparedStatement.setString(3, val3);
        
         
         int row = preparedStatement.executeUpdate();
         
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			
			log.info(e.toString());
		}
            
         
	}

	
	
	
	
	
	
}
