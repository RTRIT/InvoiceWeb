package exception;

import org.springframework.http.HttpStatus;
import lombok.Getter;

@Getter
public enum ErrorCode {
    USER_EXISTED(1004, "User existed", HttpStatus.BAD_REQUEST),
    USER_IS_NOT_EXISTED(1005, "User is not existed", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.BAD_REQUEST),
    ROLE_EXISTED(1011, "This role name is taken", HttpStatus.BAD_REQUEST),
    EMPTY_PRIVILEGE(1012, "Privilege is empty", HttpStatus.BAD_REQUEST),
    VENDOR_EXISTED(1013, "Vendor existed", HttpStatus.BAD_REQUEST),
    VENDOR_NOT_FOUND(1014, "Vendor not found", HttpStatus.BAD_REQUEST),
    INVALID_SEARCH_CRITERIA(1015, "Invalid search criteria", HttpStatus.BAD_REQUEST),
    EMAIL_EXISTED(1016, "Email existed", HttpStatus.BAD_REQUEST),
    PHONENUMBER_EXISTED(1017, "Phonenumber existed", HttpStatus.BAD_REQUEST),
    TOKEN_EXPIRED(1020, "Token has expired", HttpStatus.BAD_REQUEST),
    TOKEN_UNSUPPORTED(1021, "Unsupported JWT token", HttpStatus.BAD_REQUEST),
    TOKEN_MALFORMED(1022, "Malformed JWT token", HttpStatus.BAD_REQUEST),
    TOKEN_INVALID_SIGNATURE(1023, "Invalid JWT signature", HttpStatus.BAD_REQUEST),
    TOKEN_ILLEGAL_ARGUMENT(1024, "JWT token is empty or null", HttpStatus.BAD_REQUEST);

    private final int code;
    private final String message;
    private final HttpStatus statusCode;

    ErrorCode(int code, String message, HttpStatus statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}
    
}