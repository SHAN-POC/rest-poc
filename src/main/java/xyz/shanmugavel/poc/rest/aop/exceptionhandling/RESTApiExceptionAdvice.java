package xyz.shanmugavel.poc.rest.aop.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import xyz.shanmugavel.poc.rest.exception.EmployeeNotfoundException;

@ControllerAdvice
public class RESTApiExceptionAdvice {

  @ResponseBody
  @ExceptionHandler(EmployeeNotfoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String employeeNotFoundHandler(EmployeeNotfoundException exception) {
    return exception.getMessage();
  }
}
