package com.javaproject.employeecrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeEntry {
	
	public EmployeeData insertEmployee(EmployeeData employee){	
		try{
			Connection con = EmployeeConnection.getConnection("Employee");
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?)");
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getEmailId());
			ps.setDouble(4, employee.getSalary());
			ps.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return employee;
	}
	
	public void updateEmployee(EmployeeData employee){
		try{
			Connection con = EmployeeConnection.getConnection("Employee");
			PreparedStatement ps = con.prepareStatement("update employee set empName = ?,empEmail = ? where empId = ?");
			ps.setString(1,employee.getName());
			ps.setInt(3, employee.getId());
			ps.setString(2, employee.getEmailId());
			ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public EmployeeData getById(EmployeeData employee){
		try{
			Connection con = EmployeeConnection.getConnection("Employee");
			PreparedStatement ps = con.prepareStatement("select * from employee where empId = ?");
			ps.setInt(1, employee.getId());
			ResultSet rs = ps.executeQuery();
			rs.next();
			employee.setId(rs.getInt("empId"));
			employee.setName(rs.getString("empName"));
			employee.setEmailId(rs.getString("empEmail"));
			employee.setSalary(rs.getDouble("salary"));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return employee;
	}
	
	public List<EmployeeData> getEmployeeDetails(){
		List<EmployeeData> ed = new ArrayList<>();
		try{
			Connection con = EmployeeConnection.getConnection("Employee");
			PreparedStatement ps = con.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				EmployeeData employee = new EmployeeData();
				employee.setId(rs.getInt("empId"));
				employee.setName(rs.getString("empName"));
				employee.setEmailId(rs.getString("empEmail"));
				employee.setSalary(rs.getDouble("salary"));
				ed.add(employee);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return ed;
	}
	
	public void deleteEmployee(EmployeeData employeeData){
		try{
			Connection con = EmployeeConnection.getConnection("Employee");
			PreparedStatement ps = con.prepareStatement("delete from employee where empId = ?");
			ps.setInt(1, employeeData.getId());
			ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
}
