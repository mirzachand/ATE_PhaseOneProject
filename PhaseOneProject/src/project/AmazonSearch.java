package project;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.amazon.in/");    
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		
		WebElement Search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));	
		
		Search.click();
		
		Search.sendKeys("iphone 12");
		
		WebElement SearchClick = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		
		SearchClick.click();
		
		//To search the iPhone 12
		
		List<WebElement> iphoneName = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		
		
		//To search the price of iPhone 12
		
		List<WebElement> iphonePrice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		System.out.println("Number of results: " + iphoneName.size());
		
		
		for(int i=0;i<iphoneName.size();i++) 
		{			
			if (iphoneName.get(i).getText().contains("iPhone 12")) 
			{
				System.out.println("Product Name: " + iphoneName.get(i).getText() + ", Product Price: "+	iphonePrice.get(i).getText());
			}
		}
		
		driver.close();
		
	}

}
