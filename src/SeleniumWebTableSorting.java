import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebTableSorting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//driver.findElement(By.xpath("//a[@class='cart-header-navlink'] [1]")).click();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//table/thead/tr/th[1]")).click();
		
		Thread.sleep(1000);
		List<WebElement> itemList=driver.findElements(By.xpath("//tr/td[1]"));
		
		//Apply getText() method and capture into originalList
		List<String> originalList=itemList.stream().map(item->item.getText()).collect(Collectors.toList());
		//Sort originalList and store in sortedList
		List<String> sortedList=originalList.stream().sorted().collect(Collectors.toList());
		//Compare sortedList with originalList
		if(originalList.equals(sortedList)) {
			System.out.println("Passed.");
		}else {
			System.out.println("Failed.");
		}

	}

}
