package xyz.shanmugavel.poc.rest.api.assembler;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import xyz.shanmugavel.poc.rest.api.EmployeeController;
import xyz.shanmugavel.poc.rest.entity.Employee;

@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {

  @Override
  public EntityModel<Employee> toModel(Employee employee) {
    return EntityModel.of(employee,
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).findOne(
            employee.getId())).withSelfRel(),
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).all()).withRel("employees"));
  }

  @Override
  public CollectionModel<EntityModel<Employee>> toCollectionModel(
      Iterable<? extends Employee> employees) {
    List<EntityModel<Employee>> employeeModels = StreamSupport.stream(employees.spliterator(), false)
        .map(this::toModel)
        .collect(Collectors.toList());
    return CollectionModel.of(employeeModels, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).all()).withSelfRel());
  }
}
