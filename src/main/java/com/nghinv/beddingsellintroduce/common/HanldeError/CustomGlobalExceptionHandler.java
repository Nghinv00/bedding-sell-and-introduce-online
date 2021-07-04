package com.nghinv.beddingsellintroduce.common.hanldeError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * @author nghinv
 */

@ControllerAdvice
public class CustomGlobalExceptionHandler {

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

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleConstraintViolationException(ConstraintViolationException e, HttpServletRequest request) {
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



    @ExceptionHandler(IndexOutOfBoundsException .class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleIndexOutOfBoundsException(IndexOutOfBoundsException  e, HttpServletRequest request) {
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

    @ExceptionHandler(ArrayIndexOutOfBoundsException .class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException  e, HttpServletRequest request) {
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

    @ExceptionHandler(ExceptionInInitializerError.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleExceptionInInitializerError(ExceptionInInitializerError  e, HttpServletRequest request) {
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

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleIllegalArgumentException(IllegalArgumentException  e, HttpServletRequest request) {
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

    @ExceptionHandler(RuntimeException .class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleRuntimeException(RuntimeException  e, HttpServletRequest request) {
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

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleAllExceptions(Exception e,
                                      WebRequest request,
                                      HttpServletRequest servletRequest) {
        if (isAjax(servletRequest)) {
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

//    TODO:
//    HttpMediaTypeNotAcceptableException,
//    HttpRequestMethodNotSupportedException,
//    SocketTimeoutException,
//    UnsupportedOperationException,
//    NotReadablePropertyException
//    InvalidPropertyException
}
