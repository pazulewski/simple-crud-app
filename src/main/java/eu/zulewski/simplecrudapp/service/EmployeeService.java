package eu.zulewski.simplecrudapp.service;

import eu.zulewski.simplecrudapp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    void create(Employee employee);
}
