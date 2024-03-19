package exception;

public class CustomEnums {
	public enum ExceptionType {
	    MISSING_PARAMS_EXCEPTION(1,"MISSING_PARAMS_EXCEPTION"),
	    ITEM_NOT_FOUND_EXCEPTION(2,"ITEM_NOT_FOUND_EXCEPTION"),
	    ILLEGAL_ARGUMENT_EXCEPTION(3,"ILLEGAL_ARGUMENT_EXCEPTION"),
	    OTHER_EXCEPTION(4,"OTHER_EXCEPTION");
	    // Add more as needed

	    private final int nb;
	    private String name;

	    ExceptionType(int nb,String name) {
	        this.nb = nb;
	        this.name = name;
	    }

	    public int getErrorCode() {
	        return nb;
	    }
	    public String getName() {
	    	return name;
	    }
	}

}
