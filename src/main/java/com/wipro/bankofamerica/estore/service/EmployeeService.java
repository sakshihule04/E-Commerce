package com.wipro.bankofamerica.estore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.bankofamerica.estore.model.Employee;

@Service
public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
    List<Employee> getAllEmployees();
    
    Employee getEmployeeById(Long id);
    
    void deleteEmployee(Long id);

}
