package xyz.shanmugavel.poc.rest.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.shanmugavel.poc.rest.api.assembler.EmployeeModelAssembler;
import xyz.shanmugavel.poc.rest.entity.Employee;
import xyz.shanmugavel.poc.rest.service.EmployeeService;

@RestController
public class EmployeeController {

  public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private EmployeeModelAssembler modelAssembler;

  @GetMapping("/employees")
  public CollectionModel<EntityModel<Employee>> all() {
    LOGGER.debug("Fetch all employees.");
    return modelAssembler.toCollectionModel(employeeService.findAll());
  }

  @PostMapping("/employee")
  public ResponseEntity newEmployee(@RequestBody Employee employee) {
    LOGGER.debug("Create new employee.");
    EntityModel<Employee> employeeModel = modelAssembler.toModel(employeeService.createNew(employee));
    return ResponseEntity.created(employeeModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(employeeModel);
  }

  @GetMapping("/employee/{id}")
  public EntityModel<Employee> findOne( @PathVariable Long id) {
    LOGGER.info("Find employee by id {}.", id);
    Employee employee = employeeService.findById(id);
    return modelAssembler.toModel(employee);
  }
  @PutMapping("/employee/{id}")
  public EntityModel<Employee> updateEmployee( @PathVariable Long id, @RequestBody Employee newEmployee) {
    LOGGER.debug("Update employee {}.", id);
    Employee employee = employeeService.findById(id);
    employee.setName(newEmployee.getName());
    employee.setRole(newEmployee.getRole());
    employee = employeeService.update(employee);
    return modelAssembler.toModel(employee);
  }

  @DeleteMapping("/employee/{id}")
  public void delete(@PathVariable Long id) {
    LOGGER.info("Delete employee by id {}", id);
    employeeService.delete(id);
  }

}
