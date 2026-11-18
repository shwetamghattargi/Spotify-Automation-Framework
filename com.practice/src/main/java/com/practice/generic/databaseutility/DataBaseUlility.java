package com.practice.generic.databaseutility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;
public class DataBaseUlility {
	Connection con ;
	public void getDbConnection(String url,String username,String password)
	{try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection(url,username,password);
			}catch(Exception e){}}
	public void getDbConnection(){try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection("Jdbc:mysql://49.249.29.4:3307/ninza_hrm","root@%","root");	
		}catch(Exception e){
			
		}
	}
	public void closeDbconnection()
	{
		try {con.close();}
		catch(Exception e){
			
		}
	}
	public  ResultSet excecuteSelectquery(String query)
	{ResultSet result=null;
		try{Statement sta= con.createStatement();
			result=sta.executeQuery(query);}catch(Exception e){}return result;}
	public  int excecuteNonSelectquery(String query)
	{int result=0;try
		{Statement sta= con.createStatement();
			result=sta.executeUpdate(query);
			}catch(Exception e){}
		return result;}
}
