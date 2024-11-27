package com.java.Car_Rental_System.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.Car_Rental_System.model.Customer;
import com.java.Car_Rental_System.util.ConnectionHelper;

public class CustomerDaoImpl implements CustomerDao {
	Connection connection;
	PreparedStatement pst;
	@Override
	public List<Customer> showcustDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Customer";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Customer> customerList = new ArrayList<Customer>();
		Customer cust = null;
		while(rs.next()) {
			cust = new Customer();
			cust.setCustomer_ID(rs.getString("Customer_ID"));
			cust.setFirst_Name(rs.getString("First_Name"));
			cust.setLast_Name(rs.getString("Last_Name"));
			cust.setEmail(rs.getString("Email"));
			cust.setUser_ID(rs.getString("User_ID"));
			cust.setPassword(rs.getString("Password"));
			cust.setPhone_Number(rs.getString("Phone_Number"));
			cust.setAadhar_Number(rs.getLong("Aadhar_Number"));
			customerList.add(cust);
		}
		return customerList;
	}

	@Override
	public Customer searchByCustId(String CustomerId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Customer";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Customer> customerList = new ArrayList<Customer>();
		Customer cust = null;
		while(rs.next()) {
			cust = new Customer();
			cust.setCustomer_ID(rs.getString("Customer_ID"));
			cust.setFirst_Name(rs.getString("First_Name"));
			cust.setLast_Name(rs.getString("Last_Name"));
			cust.setEmail(rs.getString("Email"));
			cust.setUser_ID(rs.getString("User_ID"));
			cust.setPassword(rs.getString("Password"));
			cust.setPhone_Number(rs.getString("Phone_Number"));
			cust.setAadhar_Number(rs.getLong("Aadhar_Number"));
			customerList.add(cust);
		}
		return cust;
	}
	@Override
	public Customer searchByCustName(String customerName) throws SQLException, ClassNotFoundException {
	    connection = ConnectionHelper.getConnection();
	    String cmd = "SELECT * FROM Customer WHERE First_Name = ?";
	    
	    try {
	        pst = connection.prepareStatement(cmd);
	        pst.setString(1, customerName);
	        ResultSet rs = pst.executeQuery();
	        
	        if (rs.next()) {
	            Customer customer = new Customer();
	            customer.setFirst_Name(rs.getString("First_Name"));
	            customer.setLast_Name(rs.getString("Last_Name"));
	            customer.setEmail(rs.getString("Email"));
	            customer.setUser_ID(rs.getString("User_ID"));
	            customer.setPassword(rs.getString("Password"));
	            customer.setPhone_Number(rs.getString("Phone_Number"));
	            customer.setAadhar_Number(rs.getLong("Aadhar_Number"));
	            return customer; 
	        }
	    } catch (SQLException e) {
	        System.err.println("Error fetching customer: " + e.getMessage());
	        throw e;  // Re-throw the exception
	    } finally {
	        if (pst != null) pst.close();  // Close PreparedStatement to prevent resource leak
	        if (connection != null) connection.close();  // Close connection
	    }

	    return null;
	}


	@Override
	public boolean InsertCustomer(String customerID, String first, String last, String email, String userid,
			String pass, long phone, long aadhar) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into Customer(Customer_ID,First_Name,Last_Name,Email,User_ID,Password,Phone_Number,Aadhar_Number)"
				+ " values(?,?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, customerID);
		pst.setString(2, first);
		pst.setString(3, last);
		pst.setString(4, email);
		pst.setString(5, userid);
		pst.setString(6, pass);
		pst.setLong(7,phone);
		pst.setLong(8, aadhar);
		//pst.executeUpdate();
		return true;
		
	}
	
}
