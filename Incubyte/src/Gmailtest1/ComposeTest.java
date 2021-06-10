package Gmailtest1;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ComposeTest {
	
WebDriver driver;

@Given("^User Open Chrome and Nevigate to gmail$")
public void User_Open_Chrome_and_Nevigate_to_gmail() throws Throwable {
   
	System.setProperty("webdriver.chrome.driver", "D:\\Chrome91\\chromedriver_win32\\chromedriver.exe");
	 driver=new ChromeDriver();

	//  System.setProperty("webdriver.gecko.driver","D:\\fireboxDriver\\geckodriver-v0.29.1-win32\\geckodriver.exe");
	 // driver=new FirefoxDriver();
	  driver.get("https://mail.google.com/");
	//	driver.get("https://www.google.com");
		//driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
}

@Given("^Login with valid username and password$")
public void Login_with_valid_username_and_password() throws Throwable {
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("");
	driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("");
	driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
    
}

@When("^Click on compose$")
public void Click_on_compose() throws Throwable {
  driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
}

@Then("^It will open compose window$")
public void It_will_open_compose_window() throws Throwable {
	Set<String>win=driver.getWindowHandles();
	Iterator<String> it=win.iterator();
	String emailwin=it.next();
	String composewin=it.next();
	driver.switchTo().window(composewin);
	
  
}

@Then("^User enter in body  \"([^\"]*)\"$")
public void User_enter_in_body(String body) throws Throwable {
	driver.findElement(By.xpath("//div[@id=':k6']")).sendKeys(body);
   
}

@Then("^User enter in subject \"([^\"]*)\"$")
public void User_enter_in_subject(String sub) throws Throwable {
	driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys(sub);
  
}


}
