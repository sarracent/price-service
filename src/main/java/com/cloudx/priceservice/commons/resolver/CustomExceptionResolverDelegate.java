package com.cloudx.priceservice.commons.resolver;

import com.cloudx.priceservice.constants.Errors;
import com.cloudx.priceservice.exception.CustomException;
import com.cloudx.priceservice.model.response.ServiceResponse;

public class CustomExceptionResolverDelegate {

    private CustomExceptionResolverDelegate() {
    }

    public static ServiceResponse buildServiceResponse(Exception ex) {
        if (ex instanceof CustomException) {
            CustomException customException = (CustomException) ex;
            return ServiceResponse.builder()
                    .resultCode(customException.getCode())
                    .resultMessage(customException.getMessage())
                    .build();
        } else {
            return ServiceResponse.builder()
                    .resultCode(Errors.ERROR_GENERAL.getCode())
                    .resultMessage(String.format(Errors.ERROR_GENERAL.getMessage(), ex.getMessage(), ex))
                    .build();
        }
    }

}