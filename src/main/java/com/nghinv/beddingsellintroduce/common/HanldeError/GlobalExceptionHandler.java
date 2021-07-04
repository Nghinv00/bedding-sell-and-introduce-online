package com.nghinv.beddingsellintroduce.common.hanldeError;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author nghinv
 */

@ControllerAdvice
public class GlobalExceptionHandler {
        // implements ProblemHandling, SecurityAdviceTrait

//    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
//
//    @ExceptionHandler(NullPointerException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ModelAndView handleException(NullPointerException ex)
//    {
//        //Do something additional if required
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("error");
//        modelAndView.addObject("status", "BAD_REQUEST");
//        modelAndView.addObject("message", "NULL POINT");
//        return modelAndView;
//    }

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


