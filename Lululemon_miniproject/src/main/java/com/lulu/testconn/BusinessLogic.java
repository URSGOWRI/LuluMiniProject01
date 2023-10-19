package com.lulu.testconn;
import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import com.lulu.testconn.ConnectDB;

public class BusinessLogic {
	void createData() throws SQLException {

		Connection connection = ConnectDB.setupConnection();

		String query ="INSERT INTO Product ( id, name, descp,cost ) VALUES( ?, ?,?,?)";

		PreparedStatement myStmt = connection.prepareStatement(query);

		myStmt.setInt(1, 666);

		myStmt.setString(2, "pouch");

		myStmt.setString(3, "colored");

		myStmt.setInt(4, 45);

 

		int success = myStmt.executeUpdate();

		System.out.println("Added Successfully " + success);

			

		}

		void readData() throws SQLException {

			Connection connection=ConnectDB.setupConnection();

 

			 Statement statement;

			 statement = connection.createStatement();

	        ResultSet resultSet;

	        resultSet = statement.executeQuery(

	            "select * from Product where id>=111");

	        int id;

	        String name;

	        String descp;

	        int cost;

	        while (resultSet.next()) {

	            id = resultSet.getInt("id");

	            name = resultSet.getString("name");

	            descp=resultSet.getString("descp");

	            cost = resultSet.getInt("cost");

	            System.out.println("id : " + id

                        + " name : " + name + " description :"+ descp + " id : " + id);

	        }

	}

		void updateData() throws SQLException {

			Connection connection = ConnectDB.setupConnection();

			String query = "update Product set name = ? where id = ? ";

			PreparedStatement myStmt = connection.prepareStatement(query);

			myStmt.setString(1, "paint");

			myStmt.setInt(2, 555);

			boolean success = myStmt.execute();

			System.out.println("Updated Successfully " + success);

			

		}

		void deleteData() throws SQLException {

			Connection connection = ConnectDB.setupConnection();

			String query = "delete from Product where id = ? ";

			PreparedStatement myStmt = connection.prepareStatement(query);

			myStmt.setInt(1, 666);

			boolean success = myStmt.execute();

			System.out.println("Deleted Successfully " + success);

			

		}
 
	
	

}
