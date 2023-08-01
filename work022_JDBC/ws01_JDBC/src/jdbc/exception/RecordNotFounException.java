package jdbc.exception;

public class RecordNotFounException extends Exception{

	public RecordNotFounException() {
		this("This is RecordNotFounException");
	}
	
	public RecordNotFounException (String message) {
		super(message);
	}
}
