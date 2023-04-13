package xyz.shanmugavel.poc.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.shanmugavel.poc.rest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
