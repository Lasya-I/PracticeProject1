package ToolsQA.DemoMavenEclipseProject;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Simple test to run guru99 ecommerce site

public class eCommSite5 {
	
public static WebDriver driver;
	
    @BeforeTest
	public void openBrowser() throws InterruptedException
	{
	   
	   //Open the demo guru page in chrome browser	
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\SavLas\\eclipse-workspace\\Project1\\libs\\chromedriver.exe");
		
	   //Create a new Chrome browser instance 
	   driver = new ChromeDriver();
       driver.manage().window().maximize();           
       
	}
	
	//Login to the site
    @BeforeMethod
	public void loginToSite() throws InterruptedException, IOException
	{
    	
    	// Navigate to URL
    	driver.get("http://live.demoguru99.com");
        
    	//Check for the text on the home page
        String homePageText = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(homePageText, "THIS IS DEMO SITE FOR   ", "Required text not found on the home page");
        Thread.sleep(4000);
        
		//Click on my account link on the main page
		driver.findElement(By.linkText("MY ACCOUNT")).click();
		Thread.sleep(4000);
				
		//Check if the page is correct
		String acctPageTitle = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
		Assert.assertEquals(acctPageTitle, "LOGIN OR CREATE AN ACCOUNT","Reached wrong page");
		Thread.sleep(4000);
		
		//Log in to the site
	    driver.findElement(By.xpath("//input[@title='Email Address']")).sendKeys("savlas28112009@gmail.com");
	    Thread.sleep(4000);
	    
	    driver.findElement(By.id("pass")).sendKeys("lasyasri123");
	    Thread.sleep(4000);
	    
	    driver.findElement(By.name("send")).click();
	    Thread.sleep(4000);
	    
	    //Check for the text on the page
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='page-title']")).getText(), "MY DASHBOARD", "Landed in the Wrong page");
	    Thread.sleep(4000);   
	    
		System.out.println("Logged in to the Guru99 eCommerce site");
	    	
	}
    
    //Add Iphone to the cart
	@Test
	public void addItemtoCart() throws InterruptedException, IOException
	{
			
		//Go to the Mobile menu
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		Thread.sleep(4000);
			    
		//Check for the text on the MOBILE page
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='page-title category-title']")).getText(), "MOBILE", "Landed in the Wrong page");
			    
		//Add product(IPhone) to the cart
		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/button/span/span")).click();
		Thread.sleep(4000);
				
		//Check if the product is added to the Shopping cart
		Assert.assertEquals(driver.findElement(By.xpath("//h2[@class='product-name']")).getText(), "IPHONE", "IPhone not present in the shopping cart");
		Thread.sleep(4000);
			    
		//Check the price of the product present in the shopping cart
		String productPrice = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[3]/span/span")).getText();
		Thread.sleep(4000);
		
		System.out.println("Addition of item to the cart is successfull");
						
	}
	
	//Logout from the site
    @AfterMethod
	public void logoutFromSite() throws InterruptedException, IOException
	{
    	//Logout from the site
    	driver.findElement(By.xpath("//a[@class='skip-link skip-account']")).click();
    	Thread.sleep(4000);
    	
    	driver.findElement(By.xpath("//a[@title='Log Out']")).click();
    	Thread.sleep(8000);
    	
    	//Check if the user redirected to the homepage
        String homePageText = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(homePageText, "THIS IS DEMO SITE FOR   ", "Required text not found on the home page");
        Thread.sleep(4000);
        
		System.out.println("Logged out from the Guru99 eCommerce site");

    	
	}
    	
    		
    @AfterTest
	public void closeBrowser() throws InterruptedException
	{
    	//Close the window//
		driver.quit();
	}  
	
}
