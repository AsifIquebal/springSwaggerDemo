package com.example.springbootswagger2.dao;

import com.example.springbootswagger2.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAO {

    private static ArrayList<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee(101, "Tom", "Hanks", "tom.hanks@gmail.com", "5347890978", "Delhi"));
        employees.add(new Employee(201, "Stuart", "Green", "stuart.green@gmail.com", "453777990", "Banglore"));
        employees.add(new Employee(301, "Will", "Lukang", "will.lukang@gmail.com", "5678932356", "Delhi"));
    }

    public List<Employee> list() {
        return employees;
    }


    public Employee get(Long id) {

        for (Employee c : employees) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }


    public Employee create(Employee employee) {
        employee.setId(System.currentTimeMillis());
        employees.add(employee);
        return employee;
    }

    public Long delete(Long id) {

        for (Employee c : employees) {
            if (c.getId().equals(id)) {
                employees.remove(c);
                return id;
            }
        }

        return null;
    }


    public Employee update(Long id, Employee employee) {

        for (Employee c : employees) {
            if (c.getId().equals(id)) {
                employee.setId(c.getId());
                employees.remove(c);
                employees.add(employee);
                return employee;
            }
        }

        return null;
    }

}