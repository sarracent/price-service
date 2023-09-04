package com.cloudx.priceservice.commons.handler;

import com.cloudx.priceservice.commons.aop.LogAspect;
import com.cloudx.priceservice.commons.resolver.CustomExceptionResolverDelegate;
import com.cloudx.priceservice.exception.impl.*;
import com.cloudx.priceservice.model.response.ServiceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({TechnicalException.class, DataBaseException.class, ExternalException.class, Exception.class})
    public ResponseEntity<ServiceResponse> handleOtherExceptions(Exception exception, WebRequest request) {
        final var serviceResponse = CustomExceptionResolverDelegate.buildServiceResponse(exception);
        LogAspect.logFinishOperationInError(serviceResponse);
        return ResponseEntity.ok().body(serviceResponse);
    }

    @ExceptionHandler({InternalException.class})
    public ResponseEntity<ServiceResponse> handleInternalExceptions(Exception exception, WebRequest request) {
        final var serviceResponse = CustomExceptionResolverDelegate.buildServiceResponse(exception);
        LogAspect.logFinishOperationInError(serviceResponse);
        return ResponseEntity.internalServerError().body(serviceResponse);
    }

    @ExceptionHandler({ControllersException.class})
    public ResponseEntity<ServiceResponse> handleControllersExceptions(Exception exception, WebRequest request) {
        final var serviceResponse = CustomExceptionResolverDelegate.buildServiceResponse(exception);
        LogAspect.logFinishOperationInError(serviceResponse);
        return ResponseEntity.badRequest().body(serviceResponse);
    }


    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ServiceResponse> handleBusinessExceptions(Exception exception, WebRequest request) {
        final var serviceResponse = CustomExceptionResolverDelegate.buildServiceResponse(exception);
        LogAspect.logFinishOperationInError(serviceResponse);
        return ResponseEntity.ok(serviceResponse);
    }

}