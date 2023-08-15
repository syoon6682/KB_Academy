package we.pet.exception;

public class InvalidTransactionException extends Exception {
	public InvalidTransactionException(){
		this("수량보다 더 많이 살 수 없습니다. ");
	}
	public InvalidTransactionException(String message){
		super(message);
	}
}
