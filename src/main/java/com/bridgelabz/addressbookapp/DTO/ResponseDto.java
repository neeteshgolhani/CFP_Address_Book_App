package com.bridgelabz.addressbookapp.DTO;
// Response data transfer object used for API responses

public class ResponseDto {
    public String message;
    public Object data;
    // Constructor to initialize the ResponseDto with a message and data

    public ResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}