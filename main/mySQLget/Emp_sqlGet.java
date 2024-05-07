package com.example.demo.mySQLget;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.beans.Employee;

public class Emp_sqlGet {
	
	
static String url = "jdbc:mysql://127.0.0.1:3306/baza";
static String user ="root";
static String pass = "4szasdza";	
static String qu1="select * from employes;";

//getting the resultSet for database
public static ResultSet getResSet() throws SQLException {
	
Connection conn= DriverManager.getConnection(url, user, pass);
System.out.print("STATUS??? "+conn.isValid(5));
Statement st= conn.createStatement();
ResultSet resSet= st.executeQuery(qu1);
return resSet;
}

public static List<Employee> objCreation() throws SQLException {
	
List<Employee>employes= new ArrayList<>();
ResultSet resSet=getResSet();
while(resSet.next()) {
Employee employee= new Employee();
employee.setId(resSet.getInt(1));
employee.setName(resSet.getString(2));
employee.setJob_title(resSet.getString(3));
employee.setPay(resSet.getString(4));
employes.add(employee);
}
return employes;
}

public static Employee addEmpInTable(Employee employee) throws SQLException {

int id = employee.getId();
String name = employee.getName();
String job_title = employee.getJob_title();
String pay = employee.getPay();

String nm= "\""+name+"\"";
String job= "\""+job_title+"\"";
String pay2= "\""+pay+"\"";
String queri="insert into employes values ("+id+","+nm+","+job+","+pay2+")";
System.out.print("#######  "+queri);
Connection conn= DriverManager.getConnection(url, user, pass);
PreparedStatement pst= conn.prepareStatement(queri);
pst.executeUpdate();
return employee;
}

public static Employee updateTable(Employee employee) throws SQLException {
	
int id = employee.getId();
String name = employee.getName();
String job_title = employee.getJob_title();
String pay = employee.getPay();
String nm= "\""+name+"\"";
String job= "\""+job_title+"\"";
String pay2= "\""+pay+"\"";	
String q="update employes set emp_name="+nm+ "where id="+id+";";
String q1="update employes set job_title="+job+ "where id="+id+";";
String q2="update employes set pay="+pay2+ "where id="+id+";";
List<String>qu=new ArrayList<>();
qu.add(q); qu.add(q1); qu.add(q2);
Connection conn= DriverManager.getConnection(url, user, pass);
for(int a=0;a<=2;a++) {
PreparedStatement pst= conn.prepareStatement(qu.get(a));
pst.executeUpdate(); 
}
return employee;
}

public static void updateEmployeePay(int id,String pay) throws SQLException {
	
String queri="update employes set pay="+pay+ "where id="+id+";";	
Connection conn= DriverManager.getConnection(url, user, pass);
PreparedStatement pst= conn.prepareStatement(queri);
pst.executeUpdate();
conn.close();
}

public static void deleteEmployeeFromTable(int id) throws SQLException {
	
String queri="delete from employes where id="+id+";";	
Connection conn= DriverManager.getConnection(url, user, pass);
PreparedStatement pst= conn.prepareStatement(queri);
pst.executeUpdate();
conn.close();
}





}
