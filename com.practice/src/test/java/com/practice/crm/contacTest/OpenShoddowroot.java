package com.practice.crm.contacTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenShoddowroot {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
		// using getshadowroot method

//		WebElement p1 = driver.findElement(By.xpath("(//div[@class='my-3'])[1]"));
//		p1.getShadowRoot().findElement(By.cssSelector("input[placeholder='Enter your username']")).clear();
//		p1.getShadowRoot().findElement(By.cssSelector("input[placeholder='Enter your username']")).sendKeys("abc");
//		
//		WebElement p2 = driver.findElement(By.xpath("(//div[@class='my-3'])[2]"));
//		p2.getShadowRoot().findElement(By.cssSelector("input[placeholder='Enter your password']")).clear();
//		p2.getShadowRoot().findElement(By.cssSelector("input[placeholder='Enter your password']")).sendKeys("abc");
//		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		
//       using Actions class 
		Actions act=new Actions(driver);
		act.sendKeys(driver.findElement(By.xpath("//h1[.='Login']")),Keys.TAB,"xyz",Keys.TAB,"abc",Keys.TAB,Keys.ENTER).perform();
		driver.quit();
	}

}
