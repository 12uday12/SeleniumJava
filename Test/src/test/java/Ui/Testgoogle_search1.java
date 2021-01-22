package Ui;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Testgoogle_search1 {

	WebDriver driver=null;
	
	@BeforeTest
	public void setuptest()
	
	{   
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Browser\\chromedriver.exe");
        driver=new ChromeDriver();
        
        driver.get("http://www.saucedemo.com/");
        driver.manage().window().maximize();
		
	}
	
	
	@Test
	public void test1()
	{
	    ExcelUtil excel=new ExcelUtil("C:/Users/User/Desktop/Mysheet.xlsx","Sheet1");
		
		String mypassword=excel.getCelldataString(1,1);
		
		

		String myusername=excel.getCelldataString(1,0);
		System.out.println("My username data" +myusername);
		System.out.println("My password data"+mypassword);
		
		driver.findElement(By.id("user-name")).sendKeys(myusername);
		driver.findElement(By.id("password")).sendKeys(mypassword);
		driver.findElement(By.id("login-button")).click();
		
		String actualUrl="https://www.saucedemo.com/inventory.html";
        String expectedUrl= driver.getCurrentUrl();
        
        if(actualUrl.equalsIgnoreCase(expectedUrl))
        {
            System.out.println("Test case 1 successfull");
        }
        else
        {
            System.out.println("Test failed");
        }
		
		System.out.println("Login test successful");
      	
	}
	
	
	@Test
	public void test2()
	{  

		
	   driver.findElement(By.id("item_4_title_link")).click();
	   driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/button")).click();
	   
	   boolean submitbuttonPresence=driver.findElement(By.id("inventory_item_container")).isDisplayed();
	   if(submitbuttonPresence)
       {
           System.out.println("Test 2 sucessfull");
       }
       else
       {
           System.out.println("Test failed");
       }
			
    String actualUrl1="https://www.saucedemo.com/inventory-item.html?id=4";
    String expectedUrl1= driver.getCurrentUrl();
    
    if(actualUrl1.equalsIgnoreCase(expectedUrl1))
   {
        System.out.println("Test case 2 successfull");
    }
    else
    {
        System.out.println("Test failed");
  }
	        	        
	        
	}
	
	
	@Test
	public void test3()
	{         
		 boolean submitbuttonPresence=driver.findElement(By.id("inventory_item_container")).isDisplayed();
		   if(submitbuttonPresence)
	       {
	           System.out.println("Test 3 sucessfull");
	       }
	       else
	       {
	           System.out.println("Test failed");
	       }
		   driver.findElement(By.id("shopping_cart_container")).click();
		  // ("/html/body/div/div[2]/div[1]/div[2]/a/svg/path")).click();

	}
	

	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
        

		
	}
}
