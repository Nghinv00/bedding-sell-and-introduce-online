package com.nghinv.beddingsellintroduce.common.HanldeError;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author
 */

@ControllerAdvice
public class GlobalExceptionHandler  {


//    // error handle for @Valid
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers,
//                                                                  HttpStatus status, WebRequest request) {
//
//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("timestamp", new Date());
//        body.put("status", status.value());
//
//        //Get all errors
//        List<String> errors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(x -> x.getDefaultMessage())
//                .collect(Collectors.toList());
//        body.put("errors", errors);
//        System.out.println("log start");
//        System.out.println(body);
//        System.out.println("log end");
//        //
//        int errorCode = status.value();   // Valid fail -> errorCode = 400
//        System.out.println(status.value());
//        return new ResponseEntity<>(body, headers, status);
//    }

//    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NullPointerException.class)
    public ModelAndView handleException(NullPointerException ex)
    {
        //Do something additional if required
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("status", "BAD_REQUEST");
        modelAndView.addObject("message", "NULL POINT");
        return modelAndView;
    }

//    @ExceptionHandler(SQLException.class)
//    public String handleSQLException(HttpServletRequest request, SQLException ex) {
////        logger.info("SQLException Occured:: URL="+request.getRequestURL());
//        return "database_error";
//    }
//
//    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
//    @ExceptionHandler(IOException.class)
//    public String handleIOException(HttpServletRequest request, IOException ex) {
////        logger.error("IOException handler executed");
//        //returning 404 error code
//
//        return "IOException_error";
//
//    }
//
//    @ResponseStatus(reason="RuntimeException occured")
//    @ExceptionHandler(RuntimeException.class)
//    public String handleRuntimeException(HttpServletRequest request, RuntimeException ex){
////        logger.info("SQLException Occured:: URL="+request.getRequestURL());
//        return "runtime_error";
//    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
//        ExceptionResponse response = new ExceptionResponse();
//        response.setErrorCode("NOT_FOUND");
//        response.setErrorMessage(ex.getMessage());
//        response.setTimestamp(LocalDateTime.now());
//
//        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(ResourceAlreadyExists.class)
//    public ResponseEntity<ExceptionResponse> resourceAlreadyExists(ResourceAlreadyExists ex) {
//        ExceptionResponse response=new ExceptionResponse();
//        response.setErrorCode("CONFLICT");
//        response.setErrorMessage(ex.getMessage());
//        response.setTimestamp(LocalDateTime.now());
//
//        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
//    }
//
//    @ExceptionHandler(CustomException.class)
//    public ResponseEntity<ExceptionResponse> customException(CustomException ex) {
//        ExceptionResponse response=new ExceptionResponse();
//        response.setErrorCode("BAD_REQUEST");
//        response.setErrorMessage(ex.getMessage());
//        response.setTimestamp(LocalDateTime.now());
//
//        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(UnauthorizedException.class)
//    public ResponseEntity<ExceptionResponse> unauthorizedException(UnauthorizedException ex) {
//        ExceptionResponse response=new ExceptionResponse();
//        response.setErrorCode("UNAUTHORIZED");
//        response.setErrorMessage(ex.getMessage());
//        response.setTimestamp(LocalDateTime.now());
//
//        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.UNAUTHORIZED);
//    }

}


