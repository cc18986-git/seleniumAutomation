import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumScreenShot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize(); //to maximize your window
		driver.manage().deleteAllCookies(); //to delete all cookies
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Below code is to take screenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		System.out.println("Screenshot Loaction: "+System.getProperty("user.dir"));
		
		//Find current timestamp to append to file
		LocalDateTime now=LocalDateTime.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		String timeStamp=now.format(dtf);
		File targetFile=new File(System.getProperty("user.dir")+"\\ScreenShot"+timeStamp+".jpeg");
		sourceFile.renameTo(targetFile);
		
		//Take screenshot of particular area
		WebElement element=driver.findElement(By.cssSelector("img.logoClass"));
		File srcFile=element.getScreenshotAs(OutputType.FILE);
		File tarFile=new File(System.getProperty("user.dir")+"\\logo"+timeStamp+".jpeg");
		srcFile.renameTo(tarFile);
		

	}

}
