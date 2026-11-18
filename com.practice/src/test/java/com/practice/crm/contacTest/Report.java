package com.practice.crm.contacTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Report {
	 @Test  
	 public void HomepageTest(Method mtd) {      
	 Reporter.log(mtd.getName()+" Test Start");  
	  SoftAssert sa = new SoftAssert();  
	Reporter.log("Step--1",true);        
	Reporter.log("Step--2",true);        
	sa.assertEquals("Home", "Home");        
	Reporter.log("Step--3",true);  
	 Assert.assertEquals("Title", "Title");        
	Reporter.log("Step--4",true);  
	   sa.assertAll();  
	   Reporter.log(mtd.getName()+"  Test end");  
	  
	  }  

}
