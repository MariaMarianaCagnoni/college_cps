package dev.mariamariana.college_cps.controller;

import dev.mariamariana.college_cps.dto.EntityNotFoundResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExcepetionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles {@link EntityNotFoundException} by mapping it from a 500 to a 404 HTTP status.
     * The {@link EntityNotFoundException} is thrown whenever the repository cannot find and entity for a given id.
     *
     * @param ex the {@link EntityNotFoundException}
     * @return a {@link ResponseEntity} with 404 HTTP status
     */
    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<EntityNotFoundResponseDTO> handleEntityNotFound(EntityNotFoundException ex) {
        return new ResponseEntity<>(new EntityNotFoundResponseDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, ex.getMessage()), HttpStatus.NOT_FOUND);
    }


    @NonNull
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatus status,
            @NonNull WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }


}
