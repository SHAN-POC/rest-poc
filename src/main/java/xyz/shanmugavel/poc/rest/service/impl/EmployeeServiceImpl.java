package xyz.shanmugavel.poc.rest.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.shanmugavel.poc.rest.entity.Employee;
import xyz.shanmugavel.poc.rest.exception.EmployeeNotfoundException;
import xyz.shanmugavel.poc.rest.repository.EmployeeRepository;
import xyz.shanmugavel.poc.rest.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee createNew(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public Employee findById(Long id) {
    return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotfoundException(id));
  }

  @Override
  public Employee update(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public void delete(Long id) {
    employeeRepository.deleteById(id);
  }
}
