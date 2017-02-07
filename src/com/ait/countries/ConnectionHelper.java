package com.ait.countries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionHelper


{	
	String ip_string;
	public String getIP()	
	{	
		try		
		{		
			BufferedReader br = new BufferedReader( new FileReader("C:/Users/MSc_Software_Eng/workspace/CountriesProject/sql_ip.txt"));		
			Scanner in = new Scanner(br);		
			String ip_string = in.nextLine();
			in.close();
			return ip_string;			
		}
		
		catch (IOException e)
		{e.printStackTrace();
		System.out.println("Exception from read...");		
		}
		
		return ip_string;
	}
	
	private String url ="jdbc:mysql://"+(getIP())+"/countries_project_2017?user=CountriesProject&password=MSc_2017";
	private static ConnectionHelper instance;

	private ConnectionHelper()
	{		
    	String driver = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
            driver="com.mysql.jdbc.Driver";
            Class.forName(driver);            
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException 
	{
		if (instance == null)
		{
			instance = new ConnectionHelper();
		}
		
		try 
		{
			return DriverManager.getConnection(instance.url);			
		} 
		catch (SQLException e)
		{
			throw e;
		}
	}
	
	public static void close(Connection connection)
	{
		try 
		{
			if (connection != null)
			{
				connection.close();
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}
