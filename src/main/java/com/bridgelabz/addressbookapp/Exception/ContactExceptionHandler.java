package com.bridgelabz.addressbookapp.Exception;

import com.bridgelabz.addressbookapp.DTO.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

/**Section 4
 * UC3-----------------
 * Ability to throw User Friendly Errors
 * in case Address Book Id is not found
 * in Address Book App.
 *
 */
@ControllerAdvice
public class ContactExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream().map(objError -> objError.getDefaultMessage()).collect(Collectors.toList());
        ResponseDto responseDto = new ResponseDto("Exception while performing REST API", errMsg);
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ResponseDto> handleCustomEmployeeException(CustomException exception) {
        ResponseDto responseDto = new ResponseDto("Exception while performing REST API", exception.getMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
