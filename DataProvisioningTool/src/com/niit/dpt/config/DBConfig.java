package com.niit.dpt.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConfig {

	public static Connection connect()
	{
		String driver;
		String url;
		String user;
		String password;
		//Properties prop = new Properties();
		InputStream input = null;
		Connection connection=null;
		try {
			String propFileName = "E:\\Programs\\PGPJAVANEW\\DataProvisioningTool\\src\\utility.properties";
			File file = new File(propFileName);
			FileInputStream fileInput = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fileInput);
			fileInput.close();

			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			user=prop.getProperty("user");
			password=prop.getProperty("password");
			//System.out.println(driver+" "+url+" ");
			Class.forName(driver);
			connection=DriverManager.getConnection(url,user,password);
			
		/*	if(connection!= null)
				System.out.println("Connected");*/

		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return connection;

	}
}