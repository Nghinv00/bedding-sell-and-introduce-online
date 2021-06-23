package com.nghinv.beddingsellintroduce.common.HanldeError;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author nghinv
 */

@RestControllerAdvice
public class CustomGlobalExceptionHandlerApi {

    private boolean isAjax(HttpServletRequest request) {
        String requestedWithHeader = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(requestedWithHeader);
    }

    // TODO:
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleNullPointerException(NullPointerException e, HttpServletRequest request) {
        if (isAjax(request)) {
            return new ResponseEntity<>("Error with RestController: " + e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("error");
            modelAndView.addObject("status", "BAD_REQUEST");
            modelAndView.addObject("message", e.getMessage());
            return modelAndView;
        }
    }

//    // TODO:
//    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
//        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//
//
//    @ExceptionHandler(IndexOutOfBoundsException .class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<String> handleIndexOutOfBoundsException(IndexOutOfBoundsException  e) {
//        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
//    }
//
//    @ExceptionHandler(ArrayIndexOutOfBoundsException .class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<String> handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException  e) {
//        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
//    }
//
//    @ExceptionHandler(ExceptionInInitializerError.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<String> handleExceptionInInitializerError(ExceptionInInitializerError  e) {
//        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
//    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException  e) {
//        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
//    }
//
//    @ExceptionHandler(RuntimeException .class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<String> handleRuntimeException(RuntimeException  e) {
//        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
//    }
//
//    @ExceptionHandler(MyException .class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<String> handleMyException(MyException  e) {
//        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request) {
////        List<String> details = new ArrayList<>();
////        details.add(ex.getLocalizedMessage());
////        ErrorResponse error = new ErrorResponse("Server Error", details);
////        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
//
//
//        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
//    }

}
