package com.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.vo.Custom;

// Business Logic의 Template

public interface CustomDAO {
	void addCustom(Custom cust) throws SQLException;
	void deleteCustom(int id) throws SQLException;
	void updateCustom(Custom cust) throws SQLException;
	
	Custom getCutomer(int id) throws SQLException;
	ArrayList<Custom> getAllCustomer() throws SQLException;
	
	
}
