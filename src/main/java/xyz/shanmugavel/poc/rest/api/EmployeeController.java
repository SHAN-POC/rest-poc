package xyz.shanmugavel.poc.rest.api;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.shanmugavel.poc.rest.entity.Employee;
import xyz.shanmugavel.poc.rest.service.EmployeeService;

@RestController
public class EmployeeController {

  public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/employees")
  public List<Employee> all() {
    LOGGER.debug("Fetch all employees.");
    return employeeService.findAll();
  }

  @PostMapping("/employee")
  public Employee newEmployee(@RequestBody Employee employee) {
    LOGGER.debug("Create new employee.");
    return employeeService.createNew(employee);
  }

  @GetMapping("/employee/{id}")
  public Employee findOne( @PathVariable Long id) {
    LOGGER.info("Find employee by id {}.", id);
    return employeeService.findById(id);
  }
  @PutMapping("/employee/{id}")
  public Employee updateEmployee( @PathVariable Long id, @RequestBody Employee newEmployee) {
    LOGGER.debug("Update employee {}.", id);
    Employee employee = employeeService.findById(id);
    employee.setName(newEmployee.getName());
    employee.setRole(newEmployee.getRole());
    return employeeService.update(employee);
  }

  @DeleteMapping("/employee/{id}")
  public void delete(@PathVariable Long id) {
    LOGGER.info("Delete employee by id {}", id);
    employeeService.delete(id);
  }

}
