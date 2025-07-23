import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/*
		if(!driver.findElement(By.id("checkBoxOption1")).isSelected()) {
			driver.findElement(By.id("checkBoxOption1")).click();
			}
		
		if(driver.findElement(By.id("checkBoxOption1")).isSelected()) {
			driver.findElement(By.id("checkBoxOption1")).click();
			}
		
		System.out.println(driver.findElement(By.cssSelector("input[type='checkbox']")).getSize());
		//System.out.println(driver.findElement(By.cssSelector("input[type='checkbox']")).getSize());
		*/
		
		//Handling alert with only ok button
		driver.findElement(By.id("name")).sendKeys("Chetan");
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		//Handling Alert with OK/Cancel buttons
		driver.findElement(By.id("name")).sendKeys("Aniket");
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("name")).sendKeys("Aniket");
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().dismiss();
		
		

	}

}
