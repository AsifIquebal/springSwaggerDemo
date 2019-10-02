package com.example.springbootswagger2.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.springbootswagger2.dao.EmployeeDAO;
import com.example.springbootswagger2.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Swagger Rest API Demo", tags = {"Employee"})
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDAO;

	@ApiOperation(value = "Get all Employees", response = Iterable.class, tags = "Employee")
	@GetMapping(value = "/getEmployees")
	public List<Employee> getEmployees() {
		return employeeDAO.list();
	}

	@ApiOperation(value = "Get Employee by ID", response = Employee.class, tags = "Employee")
	@GetMapping("/employees/{id}")
	@ResponseBody
	public ResponseEntity<Object> getEmployeeByID(@PathVariable("id") Long id) {
		Employee employee = employeeDAO.get(id);
		if (employee == null) {
			return new ResponseEntity<>("No Employee found for ID. Check again. " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@ApiOperation(value = "Create an Employee", response = Employee.class, tags = "Employee")
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		employeeDAO.create(employee);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete employee by id", tags = "Employee")
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<java.io.Serializable> deleteEmployee(@PathVariable Long id) {
		if (null == employeeDAO.delete(id)) {
			return new ResponseEntity<>("No Employee found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@ApiOperation(value = "Update an employee", tags = "Employee")
	@PutMapping("/employees/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		employee = employeeDAO.update(id, employee);
		if (null == employee) {
			return new ResponseEntity<>("No Employee found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}



}
