package exception;

public class CustomException extends Exception {


	private static final long serialVersionUID = 1L;
	private int errorCode;

    // Constructors
    public CustomException(CustomEnums.ExceptionType exceptionType) {
        super(exceptionType.getName());
        this.errorCode = exceptionType.getErrorCode();
    }

    public CustomException(CustomEnums.ExceptionType exceptionType, Throwable cause) {
        super(exceptionType.getName(), cause);
        this.errorCode = exceptionType.getErrorCode();
    }

    // Getters
    public int getErrorCode() {
        return errorCode;
    }
}

