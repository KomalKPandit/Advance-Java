package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.Scanner;

public class EmployeeDao {
	Connection c;
	Statement s;
	Scanner sc = new Scanner(System.in);

	public void connect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeproject", "root", "Komal@123");
		s = c.createStatement();
	}

	// INSERT DATA
	public void insertData(int id, String name, String city, int salary) throws Exception {
		connect();
		String query = "INSERT INTO employee VALUES(?,?,?,?)";
		PreparedStatement stmt = c.prepareStatement(query);
		stmt.setInt(1, id);
		stmt.setString(2, name);
		stmt.setString(3, city);
		stmt.setInt(4, salary);
		stmt.executeUpdate();
		c.close();
	}

	// UPDATE DATA
	public void updateData(int id, String name, String city, int salary) throws Exception {
		connect();
		
 
	        String query = "UPDATE employee SET name = ?, city = ?,salary =?  WHERE id = ?";
	        PreparedStatement stmt = c.prepareStatement(query);
	    
			stmt.setString(2, name);
			stmt.setString(3, city);
			stmt.setInt(4, salary);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			c.close();
	        System.out.println(" Empolyee Data updated successfully.");

		c.close();
	}

	// DELETE DATA BY ID
	public void deleteData(int id) throws Exception {
		connect();
		
		 String query = "DELETE FROM employee WHERE id = ?";
	        PreparedStatement stmt = c.prepareStatement(query);
	        stmt.setInt(1, id);
	        stmt.executeUpdate();
	        
	        System.out.println(" Empolyee Data deleted successfully.");
		c.close();
		
		
		
	}

	// READ DATA
	public void readData() throws Exception {
		connect();
		ResultSet rs = s.executeQuery("SELECT * FROM employee");

		while (rs.next()) {
			System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", City: "
					+ rs.getString("city") + ", Salary: " + rs.getDouble("salary"));
		}

		c.close();
	}

}