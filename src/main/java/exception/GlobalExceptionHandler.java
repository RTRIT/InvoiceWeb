package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.hibernate.NonUniqueResultException;

import dto.response.ApiResponse;
import model.errors.ErrorDetails;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// Handle global exceptions

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<String> handleResourceNotFoundException(Exception e){
//        return ResponseEntity.status(400).body(e.getMessage());
//    }

	@ExceptionHandler(NonUniqueResultException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorDetails nonUniqueResultException(Exception ex, WebRequest request) {
		return new ErrorDetails("There are more than one this role in DB", "Testing time");
	}

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<String> handleCustomException(Exception e) {
		return ResponseEntity.status(409).body(e.getMessage());
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<String> handlingValidation(MethodArgumentNotValidException exception) {
		return ResponseEntity.badRequest().body(Objects.requireNonNull(exception.getFieldError()).getDefaultMessage());
	}

	@ExceptionHandler(value = AppException.class)
	public ResponseEntity<ApiResponse<Object>> handlingAppException(AppException exception) {
		ApiResponse<Object> response = ApiResponse.builder().code(exception.getErrorCode().getCode())
				.message(exception.getMessage()).build();

		return ResponseEntity.badRequest().body(response);
	}

}
