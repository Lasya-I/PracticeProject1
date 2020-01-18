package ToolsQA.DemoMavenEclipseProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//Testing gmail login, mail compose and logout scenarios

public class gmailTestNG {
	
	public static WebDriver driver;
	
	@Test(priority=0)
	public void openBrowser()
	{
	   
	   //Open the gmail page in chrome browser	
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\SavLas\\eclipse-workspace\\testng\\lib\\chromedriver.exe");
		
	   driver = new ChromeDriver(); 
       driver.manage().window().maximize();
       driver.get("https://www.gmail.com/"); 
       
       String login = driver.findElement(By.xpath("//span[text()='Inloggen']")).getText();
       Assert.assertEquals(login, "Inloggen", "Wrong page");
       
	}
	
	@Test(priority=1)
	public void gmailLogin() throws InterruptedException
	{
		//Login to gmail
		// Enter the user id and click on next button
		driver.findElement(By.name("identifier")).sendKeys("savlas28112009");	
		driver.findElement(By.xpath("//span[@class = 'RveJvd snByac']")).click();

		// Enter the password and click on next button		
		Thread.sleep(4000);		
		driver.findElement(By.name("password")).sendKeys("lasyasri123");			
		driver.findElement(By.xpath("//span[@class = 'RveJvd snByac']")).click();
		
		String title = driver.getTitle();
		//System.out.println(title);
		Assert.assertEquals(title, "Gmail", "Wrong page opened");	
		
		System.out.println("Logged in to the gmail user account");

		
	}
	
	@Test(priority=2)
	public void composeEmail() throws InterruptedException
	{
		//Compose a mail and send
			
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div/div[contains(text(),'Compose')]")).click();
		Thread.sleep(8000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='New Message']")).isDisplayed(),true);
		    
		driver.findElement(By.xpath("//*[@name='to']")).sendKeys("savlas28112009@gmail.com");
		driver.findElement(By.xpath("//*[@class='aoT']")).sendKeys("TestNG testmail1");
		Thread.sleep(8000);
		driver.findElement(By.className("aoO")).click(); 
		Thread.sleep(4000);
		
		System.out.println("Mail sent");

	}
	
	@Test(priority=3)
	public void gmailLogout() throws InterruptedException
	{
		//Log out of gmail and close the browser
		
		Thread.sleep(4000);
					
		//Click on the image icon present in the top right navigational Bar
        driver.findElement(By.xpath("//span[@class='gb_Ia gbii']")).click();

		//Click on 'Logout' Button
        Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@id='gb_71']")).click();
		
		//String relogin = driver.findElement(By.xpath("//span[contains(text()='Een account selecteren')]")).getText(); 
		//Assert.assertEquals(relogin, "Een account selecteren");
		Assert.assertEquals(driver.getTitle(), "Gmail", "Wrong page opened");	
		
		System.out.println("Logged out from gmail");

        		
		//Close the tab.
		driver.quit();
		
	}

	
	

}
