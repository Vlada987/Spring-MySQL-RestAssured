package com.example.demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.beans.Employee;
import com.example.demo.beans.Responces;
import com.example.demo.mySQLget.Emp_sqlGet;


@Component
public class Emp_Service {
	

public static HashMap<Integer,Employee>employesMap;

public Emp_Service() throws SQLException {
	
employesMap=new HashMap<Integer,Employee>();
List<Employee>employesList=Emp_sqlGet.objCreation();
int size= employesList.size();
for(Employee employee:employesList) {
int id=employee.getId();
employesMap.put(id, employee);
}
}

public List<Employee> getAllEmployes() {

List<Employee>employes=new ArrayList<>(employesMap.values());
return employes;

}
public Object getEmployeeByID(int id) {

String wrongID= "Non Valid ID";	
int size=employesMap.size();
if(id>size) {
return wrongID;
}
else { 
Employee employee= employesMap.get(id);
return employee;
}
}
public Employee getEmployeeByName(String name) {
	
Employee employee=null;
for(int a:employesMap.keySet()) {
if(employesMap.get(a).getName().equals(name)) {
employee=employesMap.get(a);	
}
}
return employee;
}

public Object addNewEmployee(Employee employee) throws SQLException {

int maxID=employesMap.size()+1;
employee.setId(maxID);
Emp_sqlGet.addEmpInTable(employee);
return employee;
}

public Object UpdateEmploye(Employee employee) throws SQLException {
	
Emp_sqlGet.updateTable(employee);
return employee;
}

public Responces updateEmployeePay(int id,String pay) throws SQLException {

Responces resp=new Responces();
if(id>employesMap.size()) {
resp.setMessage("Non Valid ID");
}
else {
Emp_sqlGet.updateEmployeePay(id, pay);
resp.setMessage("Employee with ID:"+id+" has been updated");
}
return resp;
}

public Responces deleteEmployee(int id) throws SQLException {


Responces resp=new Responces();
if(id>employesMap.size()) {
resp.setMessage("Non Valid ID");
}
else {
Emp_sqlGet.deleteEmployeeFromTable(id);
resp.setMessage("Employee with ID:"+id+" has been deleted");
}
return resp;
}






}
