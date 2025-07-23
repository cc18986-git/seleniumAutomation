import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntro {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*Here we're specifying where to find chrome driver. If we don't give this then Selenium
		  Manager comes into picture and does the job for us.
		*/
		//System.setProperty("webdriver.chrome.driver", "/Users/chava/chromedriver/chromedriver.exe");
		
		/*WebDriver is Interface and we used this cause we only want ChromeDriver to access
		  only WebDriver methods, if we use ChroeDriver then this might not work on other browsers
		  if we're implementing methods specific to ChromeDriver.
		*/
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println("URL Title: " + driver.getTitle());
		System.out.println("Web URL: " + driver.getCurrentUrl());
		
		driver.findElement(By.id("inputUsername")).sendKeys("cc18986@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys("ABCD");
		driver.findElement(By.className("signInBtn")).click();
		String errorText=driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(errorText);
		
		//Code for forgot password
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Chetan");	
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Chetan@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("9890968532");
		driver.findElement(By.className("reset-pwd-btn")).click();
		Thread.sleep(1000);
		
		String errMsg=driver.findElement(By.cssSelector("form p")).getText();
		String[] arrMsg=errMsg.split("'");
		String pwd=arrMsg[1];
		System.out.println(pwd);
				
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("inputUsername")).sendKeys("Chetan");
		driver.findElement(By.name("inputPassword")).sendKeys(pwd);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		String successMsg=driver.findElement(By.tagName("p")).getText();
		System.out.println(successMsg);
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		

	}

}
