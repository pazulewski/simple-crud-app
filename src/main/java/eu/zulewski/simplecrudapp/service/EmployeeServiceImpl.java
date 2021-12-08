package eu.zulewski.simplecrudapp.service;

import eu.zulewski.simplecrudapp.entity.Employee;
import eu.zulewski.simplecrudapp.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }
}
