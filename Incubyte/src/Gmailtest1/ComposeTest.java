package Gmailtest1;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ComposeTest {
	
WebDriver driver;

@Given("^User Open Chrome and Nevigate to gmail$")
public void User_Open_Chrome_and_Nevigate_to_gmail() throws Throwable {
   
	System.setProperty("webdriver.chrome.driver", "F:\\Training\\chromedriver_win32\\chromedriver.exe");
	
	 driver=new ChromeDriver();
	 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	  driver.get("https://www.gmail.com");
	
}

@Given("^Login with valid username and password$")
public void Login_with_valid_username_and_password() throws Throwable {
	
	
	 
	driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(""); //enter user email
	driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	
	
	WebElement  password=driver.findElement(By.xpath("//input[@name='password']"));
	 WebDriverWait wait=new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.elementToBeClickable(password));
	  password.sendKeys("");//enter user password
	driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
    
}

@When("^Click on compose$")
public void Click_on_compose() throws Throwable {
  driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
}


@Then("^User enter in body  \"([^\"]*)\"$")
public void User_enter_in_body(String body) throws Throwable {
	driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[2]/div[2]/div[1]")).sendKeys(body);
   
}

@Then("^User enter in subject \"([^\"]*)\"$")
public void User_enter_in_subject(String sub) throws Throwable {
	driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys(sub);
  
}


}
