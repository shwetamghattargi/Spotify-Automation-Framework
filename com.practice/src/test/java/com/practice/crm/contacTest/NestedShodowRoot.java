package com.practice.crm.contacTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NestedShodowRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoapps.qspiders.com/ui/shadow/nested?sublist=2");
		//open-close
		 SearchContext host = driver.findElement(By.xpath("//div[@class='shadowOuter']")).getShadowRoot();
		Actions act= new Actions(driver);
		act.sendKeys(host.findElement(By.cssSelector("label[for='email")),Keys.TAB,"hii").perform();
		//close-open
		act.sendKeys(driver.findElement(By.cssSelector("label[for='password']")),"bye");
		
	}

}
