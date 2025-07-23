import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		WebElement account=driver.findElement(By.cssSelector("div[id='nav-link-accountList']"));
		act.moveToElement(account).build().perform();
		
		WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
		//type in upper case
		//act.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("kids scooter").build().perform();
		//type in camel case
		act.moveToElement(searchBox).click();
		act.keyDown(Keys.SHIFT).sendKeys("k")
		.keyUp(Keys.SHIFT).sendKeys("ids")
		.keyDown(Keys.SHIFT).sendKeys(" s")
		.keyUp(Keys.SHIFT).sendKeys("cooter");

	}

}
