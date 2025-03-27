package desafio.backend.loan.execption;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity errorBadRequest(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(fieldErrors.stream().map(DataErrorsValidator::new).collect(Collectors.toList()));
    }

    private record DataErrorsValidator(String field, String message) {
        public DataErrorsValidator(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
