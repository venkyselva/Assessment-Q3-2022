package Nallas.Nallas_demoproject.TestBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class common_function extends testbase

{
	
	public common_function()
	{
			
			PageFactory.initElements(driver, this);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	public static void sendkeys(String value, String log_message)
	{
		try
		{
		
		Actions actn = new Actions(driver);
		System.out.println(value);
		actn.sendKeys(value);
		logMessage_withScreenshot(log_message);
		
	   }
	   catch (Exception e)
	    {
		Error_withScreenshot(e.toString());
		log.info(e.toString());
	     }
	}
	
	public static void sendkeys_onebyone(String value, String log_message)
	{
		try
		{
		
		Actions actn = new Actions(driver);
		System.out.println(value);
		int length = value.length();
		
		for (int a =0; a<length;a++)
		{
			char val = value.charAt(a);
			String val_str = Character.toString(val);
			actn.sendKeys(val_str).perform();
			Thread.sleep(1000);
		}
		
		
		
		logMessage_withScreenshot(log_message);
		
	   }
	   catch (Exception e)
	    {
		Error_withScreenshot(e.toString());
		log.info(e.toString());
	     }
	}
	
	
	public static void Convert_to_selectelement(WebElement element, String option, String log_message)
	{
		try
		{
		Actions action = new Actions(driver);
		
		Select Select_element = new Select(element);
		
		Select_element.selectByValue(option);
		
		action.moveToElement(element).perform();
	    webelement_hightlight(element);
		logMessage_withScreenshot(log_message);
		
	    }
	   catch (Exception e)
	    {
		Error_withScreenshot(e.toString());
		log.info(e.toString());
	     }
	}
	
	
	public static void Verify_text(String Expected_value, String Actual_value )
	{
		if(Expected_value.equalsIgnoreCase(Actual_value)|| Expected_value.contains(Actual_value)||Actual_value.contains(Expected_value)) 
		{
			System.out.println("Expected value displayed in Webelement");
			logMessage_withScreenshot("Expected Value Verification: Success"+"Ex.value: "+Expected_value+ "Act.value :"+Actual_value);
						
		}
		else
		{
			Error_withScreenshot("Expected Value Verification: Failed"+"Ex.value: "+Expected_value+ "Act.value :"+Actual_value);
		}
		
	}
	
	
	
	
	
	public static void elementclick(WebElement element, String text) throws InterruptedException
	{
		try
		{
		Wait_elementclickable(element);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
		webelement_hightlight(element);
		logMessage_withScreenshot(text);
		
		element.click();
		log.info(text);
		}
		catch (Exception e)
		{
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		}
	}
	
	public static void elementclick_centerposition(WebElement element, String text) throws InterruptedException
	{
		try
		{
		int wid =	element.getSize().width/2;
		int hig	= element.getSize().height/2;
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
		//webelement_hightlight(element);
		new Actions(driver).moveToElement(element, wid, hig).click().build().perform();
		logMessage_withScreenshot(text);
		
		log.info(text);
		}
		catch (Exception e)
		{
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		}
	}
	
	public static void elementclick_cssselector(String css, String text) throws InterruptedException
	{
		try
		{
		WebElement element = driver.findElement(By.cssSelector(css));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		//webelement_hightlight(element);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		log.info(text);
		}
		catch (Exception e)
		{
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		}
	}
	
	
	
	public static void elementclick_withclear(WebElement element, String text) throws InterruptedException
	{
		try
		{
		Wait_elementclickable(element);
		
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
		webelement_hightlight(element);
		logMessage_withScreenshot(text);
		element.clear();
		element.click();
		element.clear();
		log.info(text);
		}
		catch (Exception e)
		{
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		}
	}
	
	
	public static void elementclick_JS(WebElement element, String text) throws InterruptedException
	{
		
		logMessage_withScreenshot(text);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		log.info(text);
	}
	

	public static void elementclick_action(WebElement element, String text) throws InterruptedException
	{
		
		
		 Actions a = new Actions(driver);
	      a.moveToElement(element).
	      click().build().perform();
	      logMessage_withScreenshot(text);
		log.info(text);
	}
	
	public static void elementclick_basedoncoordinate(WebElement element, String text) throws InterruptedException
	{
		
		Point location = element.getLocation();
		int xcord = location.getX();
		int ycord = location.getY();
		Rectangle rect = element.getRect();

		int px = rect.getX();

		int py = rect.getY();

		int h = rect.getHeight();

		int w = rect.getWidth();
		
	   System.out.println( xcord+ycord);
		 Actions actions = new Actions(driver);
		 webelement_hightlight(element);
		 actions.moveToElement(element,0,0).click().build().perform();
		 actions.moveToElement(element, px, py).click().build().perform();
			//actions.moveByOffset(xcord, ycord).click().perform();
	      logMessage_withScreenshot(text);
		log.info(text);
	}
	
	
	public static void Scroll_to_Bottom()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	    
	}

	public static String get_attribute_value(WebElement ele, String attribute)
	{
		String value = ele.getAttribute(attribute);
		System.out.println("Element attribute : "+attribute+ "-"+ value);
		return value;
	}
	
	public static WebElement find_element_from_index(String xpath, int index)
	{
		List<WebElement> element_list = driver.findElements(By.xpath(xpath));
		
		WebElement finalelement = element_list.get(index);
		return finalelement;
		
	}

	
	public static String db_connection() throws ClassNotFoundException, SQLException
	{
		String dbstr = null;
		try
		
		{
		String url="jdbc:jtds:sqlserver://DESKTOP-FG7QG1S//MSSQLSERVER01;"+ "databaseName=demo_database;";
		
		//Database Username		
		String username = "Venkateshwaran";	
        
		//Database Password		
		String password = "123456";
		String query ="select *  from demo_table;"; 
		
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		 Connection con = DriverManager.getConnection(url,username,password);
		 Statement stmt = con.createStatement();					
	       
			// Execute the SQL Query. Store results in ResultSet		
  		ResultSet rs= stmt.executeQuery(query);							
  
  		// While Loop to iterate through all data and print results		
  		
			while (rs.next())
			{
				
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			log.info(e.toString());
		}
		return dbstr;
		
	}
	
	
	
	public int find_array_index( int[] int_array, int sum) throws SQLException 
	{
	
		 int sum_array = 0;
		 int find_endindex=0;
		 
		for(int a= 0; a<int_array.length;  a++)
		{
			 sum_array +=int_array[a];
			 
			 if(sum_array==sum)
			 {
				 find_endindex = a+1;
				 break;
			 }
			 
			 else
			 {
				 continue;
			 }
			
		}
		
		return find_endindex;
		
	}
	
	public static void webelement_hightlight(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        //use executeScript() method and pass the arguments
        //Here i pass values based on css style. Yellow background color with solid red color border.
       js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}
	
	public static void Wait_elementclickable(WebElement element) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	
	
	public static void webelement_Scrollview(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        //use executeScript() method and pass the arguments
        //Here i pass values based on css style. Yellow background color with solid red color border.
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void webelement_setnull(WebElement element) throws InterruptedException
	{
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		element.click();
        //use executeScript() method and pass the arguments
        //Here i pass values based on css style. Yellow background color with solid red color border.
		js.executeScript("arguments[0].value ='';", element);
		Thread.sleep(4000);
		log.info("Text field set null");
	}
	
	public static void webelement_settext(WebElement element, String value) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		element.click();
        //use executeScript() method and pass the arguments
        //Here i pass values based on css style. Yellow background color with solid red color border.
		js.executeScript("arguments[0].setAttribute('value', '" + value +"')", element);
		
		Thread.sleep(4000);
		log.info("Text field set value"+value);
	}
	
	public static void SelectAll_delete(WebElement element) throws InterruptedException
	{
	Actions action = new Actions(driver); 
	Thread.sleep(4000);
	element.click();
	action.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	action.sendKeys(Keys.chord(Keys.DELETE));
	element.click();
	}
	
	
	
}
