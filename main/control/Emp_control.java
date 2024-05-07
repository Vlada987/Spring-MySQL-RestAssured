package com.example.demo.control;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Employee;
import com.example.demo.beans.Responces;
import com.example.demo.service.Emp_Service;

@RestController
@RequestMapping
public class Emp_control {
	
@Autowired	
Emp_Service service;

@GetMapping("/employes")
public List<Employee>getAllWorkers(){
	
return service.getAllEmployes();
}

@GetMapping("/employes/{id}")
public Object getWorkerByID(@PathVariable(name="id")int id) {

return service.getEmployeeByID(id);
}

@GetMapping("/employes/name")
public Employee getWorkerByName(@RequestParam(name="name")String name) {
	
return service.getEmployeeByName(name);
}

@PostMapping("/employee")
public Object addNewWorker(@RequestBody Employee employee) throws SQLException {
	
return service.addNewEmployee(employee);
}

@PutMapping("/employeepay/{id}")
public Object updateWorker(@PathVariable(name="id")int id, @RequestBody String pay) throws SQLException {
	
return service.updateEmployeePay(id, pay);
}

@PutMapping("/employeeupdate")
public Object updateWorker(@RequestBody Employee employee) throws SQLException {
	
return service.UpdateEmploye(employee);
}

@DeleteMapping("/employee/{id}")
public Responces deleteWorker(@PathVariable(name="id")int id) throws SQLException {
	
return service.deleteEmployee(id);
}


}
