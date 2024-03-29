package datadrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadFromDatabase {

	public static void main(String[] args) throws SQLException {
		//Step 1: create an instance for JDBC driver
		// Driver should be imported from com.mysql.cj.jdbc
		Driver dbdriver= new Driver();
		
		//Step 2: Register to dbDriver
		DriverManager.registerDriver(dbdriver);
		
		//Step 3: Establish connection to mysql
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium","root","root");
		
		//Step 4: Create Statement
		Statement statement = con.createStatement();
		
		//Step 5: Execute query to fetch data from database
		ResultSet result = statement.executeQuery("select * from employee;");
		
	while(result.next())
	{
		System.out.println(result.getInt("EmpID")+"\t"+result.getString("EmpName"));
	}
		
		//Step 6 : Close the database connection (Mandatory)
	con.close();
		
	}
}
