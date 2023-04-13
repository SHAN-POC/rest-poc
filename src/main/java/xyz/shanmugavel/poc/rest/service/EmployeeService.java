package xyz.shanmugavel.poc.rest.service;

import java.util.List;
import xyz.shanmugavel.poc.rest.entity.Employee;

public interface EmployeeService {

  List<Employee> findAll();
  Employee createNew(Employee employee);

  Employee findById(Long id);

  Employee update(Employee employee);

  void delete(Long id);
}
