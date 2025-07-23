import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumInvokingMultiWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Open new tab
		driver.switchTo().newWindow(WindowType.TAB);
		
		//Get window handles of all opened windows (Parent and Child)
		Set<String> handles=driver.getWindowHandles();
		
		//Use Iterator method to find IDs
		Iterator<String> it=handles.iterator();
		String parentWindowID=it.next();
		String childWindowID=it.next();
		
		//Switch  to child window and open new url
		driver.switchTo().window(childWindowID);
		driver.get("https://rahulshettyacademy.com/");
		
		//Grab text from another website and close
		String courseName=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.close();
		
		//Switch back to parent and perform operation
		driver.switchTo().window(parentWindowID);
		driver.findElement(By.xpath("//label[text()='Name']/following-sibling::input")).sendKeys(courseName);
		

	}

}
