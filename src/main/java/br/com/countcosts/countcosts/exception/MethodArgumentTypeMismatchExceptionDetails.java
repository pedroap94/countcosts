package br.com.countcosts.countcosts.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MethodArgumentTypeMismatchExceptionDetails {
    private String title;
    private int status;
    private String developerMessage;
    private LocalDateTime timestamp;
}
