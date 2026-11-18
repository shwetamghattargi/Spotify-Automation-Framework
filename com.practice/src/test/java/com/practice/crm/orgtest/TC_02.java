package com.practice.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.practice.generic.Fileutility.ExcelUlility;
import com.practice.generic.Fileutility.FileUtility;
import com.practice.generic.WebDriverutility.JavaUlility;

public class TC_02 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		JavaUlility jvu=new JavaUlility();

		
		FileUtility fis = new FileUtility();
		String browser = fis.getDatafromPropertiesFile("browser");
		String url = fis.getDatafromPropertiesFile("url");
		String username = fis.getDatafromPropertiesFile("username");
		String password = fis.getDatafromPropertiesFile("password");
		ExcelUlility eu= new ExcelUlility();
		String name = eu.getDataFromExcelFile("org", 4, 2)+jvu.getRandomNumber();
		String Energy = eu.getDataFromExcelFile("org", 4, 3);
		String press = eu.getDataFromExcelFile("org", 4, 4);
		WebDriver driver=null;
		if(browser.equals("Chrome"))
			driver=new ChromeDriver();
		else if(browser.equals("Firefox"))
			driver=new FirefoxDriver();
		else if(browser.equals("Edge"))
			driver= new EdgeDriver();
		else
			driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(name);	
	WebElement Industry = driver.findElement(By.name("industry"));
	WebElement Type=driver.findElement(By.name("accounttype"));
	Select sel= new Select(Industry);
	sel.selectByVisibleText(Energy);
	Select sel2= new Select(Type);
	sel2.selectByContainsVisibleText(press);
	driver.findElement(By.name("button")).click();
	String actdata = driver.findElement(By.id("mouseArea_Industry")).getText();
	String actdata1 = driver.findElement(By.id("mouseArea_Type")).getText();
	if(actdata.equals(Energy))
		System.out.println("orgname create with Energy "+"verified==pass");
	else
		System.out.println("orgname create with Energy "+"verified==fail");
	if(actdata1.equals(press))
		System.out.println("orgname create with Energy "+"verified==pass");
	else
		System.out.println("orgname create with Energy "+"verified==fail");

	driver.close();

	




	}

}
