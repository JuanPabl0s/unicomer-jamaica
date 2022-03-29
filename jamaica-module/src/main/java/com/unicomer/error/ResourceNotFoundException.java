package com.unicomer.error;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException{


    @Serial
    private static final long serialVersionUID = 5843859357853620044L;

    public ResourceNotFoundException(String message){
        super(message);
    }
}
