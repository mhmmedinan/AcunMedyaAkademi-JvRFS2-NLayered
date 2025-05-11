package com.acunmedya_jvrfs2.RentACar.common.exceptions.handlers;

import com.acunmedya_jvrfs2.RentACar.common.exceptions.details.BusinessProblemDetails;
import com.acunmedya_jvrfs2.RentACar.common.exceptions.details.InternalServerProblemDetails;
import com.acunmedya_jvrfs2.RentACar.common.exceptions.details.ValidationProblemDetails;
import com.acunmedya_jvrfs2.RentACar.common.exceptions.types.BusinessException;
import com.acunmedya_jvrfs2.RentACar.common.exceptions.types.InternalServerException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException businessException){
        BusinessProblemDetails details = new BusinessProblemDetails();
        details.setDetail(businessException.getMessage());
        return details;
    }


    @ExceptionHandler({InternalServerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public InternalServerProblemDetails handleInternalServerException(InternalServerException internalServerException){
        InternalServerProblemDetails details = new InternalServerProblemDetails();
        details.setDetail(internalServerException.getMessage());
        return details;
    }


    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception){
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        Map<String,String> errorDetails = new HashMap<>();
        for (FieldError error : fieldErrors){
            errorDetails.put(error.getField(),error.getDefaultMessage());
        }

        ValidationProblemDetails problemDetails = new ValidationProblemDetails();
        problemDetails.setErrors(errorDetails);
        return problemDetails;
    }
}
