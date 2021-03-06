package com.project.example.model.imdb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class imdbException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public imdbException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }


    public String getFieldName() {
        return fieldName;
    }

}
