package com.softsignatureslab.ecommerce.exceptions;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(String message){
        super(message);
    }
}
