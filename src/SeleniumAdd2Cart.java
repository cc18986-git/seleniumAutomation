import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumAdd2Cart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//Implicit Wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		
		String[] items= {"Brocolli","Cucumber"};
		List<String> prodList= new ArrayList<>(Arrays.asList(items));
		add2Cart(driver,prodList);
		

	}
	
	public static void add2Cart(WebDriver driver, List<String> prodList) {
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		System.out.println("Total no of items to purchase: "+prodList.size());
			int j=0;
			for(int i=0;i<products.size();i++) 
			{
				String prodElement=products.get(i).getText();
				String[] prodSplit=prodElement.split("-");
				String prodName=prodSplit[0].trim();
				if(j<=prodList.size()-1) 
				{
					if(prodList.contains(prodName)) 
					{
					System.out.println(prodName +" Found.");
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
					j++;
					}
				}
				else {
					System.out.println("All items found.");
					break;
				}
			
			}
		//select cart and goto to checkout
			driver.findElement(By.cssSelector("img[alt='Cart']")).click();
			driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
			
			//Explicit Wait
			WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
			driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
			
			driver.findElement(By.cssSelector("button.promoBtn")).click();
			
			//Explicit Wait
			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
			String promoMsg=driver.findElement(By.cssSelector("span.promoInfo")).getText();
			System.out.println("Promo Code Message: "+promoMsg);
	}

}
