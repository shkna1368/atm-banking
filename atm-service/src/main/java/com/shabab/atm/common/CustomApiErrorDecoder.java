package com.shabab.atm.common;


import com.shabab.atm.exception.AccessDeniedException;
import com.shabab.atm.exception.BadRequestException;
import com.shabab.atm.exception.NotFoundException;
import com.shabab.atm.exception.ServiceUnavailableException;
import feign.Response;
import feign.codec.ErrorDecoder;


public class CustomApiErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {


        switch (response.status()){
            case 400:
                return new BadRequestException("Bad Request");
            case 403:
                return new AccessDeniedException("Access Denied");
            case 404:
                return new NotFoundException("Not Fount");

                 case 500:
                 case 501:
                 case 502:
                 case 503:
                return new ServiceUnavailableException("Unavailbale Exception");


            default:
                return new Exception("Generic error");
        }
    }
}