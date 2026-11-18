package com.practice.crm.orgtest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SimpleTestWithPom {
	@FindBy(name="user_name")
	WebElement ele1;
	@FindBy(name="user_password")
	WebElement ele2;
	@FindBy(id="submitButton")
	WebElement ele3;
	@Test
	public void sample()
	{
		System.out.println("hi");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.29.4:8888/");
		SimpleTestWithPom s1 = PageFactory.initElements(driver,SimpleTestWithPom.class);
		s1.ele1.sendKeys("admin");
		s1.ele2.sendKeys("admin");
		driver.navigate().refresh();
		s1.ele1.sendKeys("admin");
		s1.ele2.sendKeys("admin");
		s1.ele3.click();


	}

}
