import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBrokenLinks {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		List<WebElement> links=driver.findElements(By.cssSelector("li[class=gf-li] a"));
		System.out.println("Total No of Links: "+links.size());
		int totalBrokenLinks=0;
		
		for(WebElement element:links) {
			String hrefVal=element.getAttribute("href");
			if(hrefVal==null || hrefVal.isEmpty()) {
				System.out.println("Not Possible");
				continue;
			}
			
		//Convert href value to URL
		URL url=new URL(hrefVal);
		try {
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			conn.connect();
			if(conn.getResponseCode()>=400) {
				totalBrokenLinks++;
				System.out.println("Broken Link: "+element.getText());
			}
			}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		System.out.println("Total Broken Links: "+totalBrokenLinks);

	}

}
