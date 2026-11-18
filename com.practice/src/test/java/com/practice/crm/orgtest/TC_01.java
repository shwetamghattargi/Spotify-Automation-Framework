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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.practice.generic.Fileutility.ExcelUlility;
import com.practice.generic.Fileutility.FileUtility;
import com.practice.generic.WebDriverutility.JavaUlility;

public class TC_01 {

	public static void main(String[] args) throws IOException {
		JavaUlility jvu=new JavaUlility();
		FileUtility fis = new FileUtility();
		String browser = fis.getDatafromPropertiesFile("browser");
		String url = fis.getDatafromPropertiesFile("url");
		String username = fis.getDatafromPropertiesFile("username");
		String password = fis.getDatafromPropertiesFile("password");
		ExcelUlility eu= new ExcelUlility();
		String data = eu.getDataFromExcelFile("org", 1, 2)+jvu.getRandomNumber();
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
		driver.findElement(By.name("accountname")).sendKeys(data);	
		driver.findElement(By.name("button")).click();
		String acudata = driver.findElement(By.className("dvHeaderText")).getText();
		if(acudata.contains(data)) {
			System.out.println("orgname"+"header is verified==pass");
		}
		else
			System.out.println("orgname"+"header is verified==fail");
		String orgdata = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(orgdata.equals(data))
				System.out.println("orgname"+"orgname is verified==pass");

		else
			System.out.println("orgname"+"orgname is verified==pass");
		driver.quit();

		

		
	}

}
