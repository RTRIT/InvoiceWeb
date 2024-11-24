package exception;

public class CustomException extends AppException {
    public CustomException(String message){
        super(ErrorCode.USER_EXISTED);
    }
}
