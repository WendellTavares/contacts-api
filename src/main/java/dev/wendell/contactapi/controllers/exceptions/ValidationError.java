package dev.wendell.contactapi.controllers.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<String> details = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String message, String path , List<String> details ) {
        super(timestamp, status, error, message, path);
        this.details = details;
    }

    public ValidationError(Instant timestamp, Integer status, String error, String message, String path ) {
        super(timestamp, status, error, message, path);
    }

}
