package com.practice.generic.Fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUlility {
	public String getDataFromExcelFile(String sheetname,int rownum,int calnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1 = new FileInputStream("./TestData\\Book.xlsx");

		Workbook wb = WorkbookFactory.create(fis1);
		String data = wb.getSheet(sheetname).getRow(rownum).getCell(calnum).getStringCellValue();
		wb.close();
		return data;
	}
	public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1 = new FileInputStream("./TestData\\Book.xlsx");

		Workbook wb = WorkbookFactory.create(fis1);
		int rowcount = wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		return rowcount;
	}
	public void setDataIntoExcel(String sheetname,int rownum,int calnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1 = new FileInputStream("./TestData\\Book.xlsx");

		Workbook wb = WorkbookFactory.create(fis1);
		wb.getSheet(sheetname).getRow(rownum).createCell(calnum);
		FileOutputStream fos= new FileOutputStream("./TestData\\Book.xlsx");
		wb.write(fos);
		wb.close();
	}

}
