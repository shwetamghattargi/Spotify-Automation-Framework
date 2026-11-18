package com.practice.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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

public class Tc_03 {

	public static void main(String[] args) throws IOException {
		JavaUlility jvu=new JavaUlility();

		
		FileUtility fis = new FileUtility();
		String browser = fis.getDatafromPropertiesFile("browser");
		String url = fis.getDatafromPropertiesFile("url");
		String username = fis.getDatafromPropertiesFile("username");
		String password = fis.getDatafromPropertiesFile("password");
		ExcelUlility eu= new ExcelUlility();
		String name = eu.getDataFromExcelFile("org", 7, 2)+jvu.getRandomNumber();
		String number = eu.getDataFromExcelFile("org", 7, 3);
		WebDriver driver=null;
		if(browser.equals("Chrome"))
			driver=new ChromeDriver();
		else if(browser.equals("Firefox"))
			driver=new FirefoxDriver();
		else if(browser.equals("Edge"))
			driver= new EdgeDriver();
		else
			driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(name);	
		driver.findElement(By.id("phone")).sendKeys(number);
		driver.findElement(By.name("button")).click();
		String expectednumber = driver.findElement(By.id("dtlview_Phone")).getText();
		if(expectednumber.equals(number))
		
			System.out.println("org is create with number"+"test case is ==pass");
		else
			System.out.println("org is create with number"+"test case is ==pass");

		driver.quit();
		


	


	}

}
