package com.bridgelabz.addressbookapp.Exception;
/** Section 4
 * UC2---------------------
 *
 * Provide User Friendly Error
 * Response in case validation fails
 */
public class CustomException extends RuntimeException {
    public CustomException(String message){
        super(message);
    }
}
