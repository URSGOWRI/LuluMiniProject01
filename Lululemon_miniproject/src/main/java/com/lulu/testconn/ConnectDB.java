package com.lulu.testconn;
import java.sql.Connection;

import java.sql.DriverManager;

public class ConnectDB {
	static Connection connection;

	public static Connection setupConnection() {

 

		try {

			 Class.forName("com.mysql.cj.jdbc.Driver");//drive support sets up

 

	         connection = DriverManager.getConnection("my path",

	            "root", " ");

		}

		catch(Exception E) {

 

		}

		return connection;

	}
	

}
