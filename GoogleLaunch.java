package ToolsQA.DemoMavenEclipseProject;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class GoogleLaunch {

	 @Test
	 public void openWebPage() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");        
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SavLas\\eclipse-workspace\\Selenium\\libs\\chromedriver.exe");
		//for launching or invoking new chrome instance
        WebDriver driver = new ChromeDriver(); //driver is the object of the Webdriver class pointing to the new chrome instance
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");      
                            
        //identifying the hyperlink using linktext
        driver.findElement(By.linkText("Gmail")).click();
        Thread.sleep(4000);
        
        System.out.println("Google launch successful");
        
        //Close the browser
        driver.quit();
        
	}

}
