package com.practice.generic.Fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getDatafromPropertiesFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./configApp/commanddt.properties");
		Properties ps= new Properties();
		ps.load(fis);
		String data = ps.getProperty(key);
		return data;
	}

}

