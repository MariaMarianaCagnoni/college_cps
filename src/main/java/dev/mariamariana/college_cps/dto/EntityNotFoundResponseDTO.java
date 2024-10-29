package dev.mariamariana.college_cps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityNotFoundResponseDTO implements Serializable {
    private int code;
    private HttpStatus error;
    private String message;
}
