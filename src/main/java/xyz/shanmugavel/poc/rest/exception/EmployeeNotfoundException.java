package xyz.shanmugavel.poc.rest.exception;

public class EmployeeNotfoundException extends RuntimeException{

  public EmployeeNotfoundException(Long id) {
    super("Employee not found for this id " + id);
  }
}
