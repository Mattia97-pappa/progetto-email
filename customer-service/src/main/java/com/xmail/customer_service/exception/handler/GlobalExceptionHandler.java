package com.xmail.customer_service.exception.handler;



import com.xmail.customer_service.exception.custom.CustomerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
   public ProblemDetail handleCustomerNotFoundException(CustomerNotFoundException ex){
       log.warn(ex.getMessage());
       ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
       problem.setTitle("Customer not found");
        return problem;
    }


}
