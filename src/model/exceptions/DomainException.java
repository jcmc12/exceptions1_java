package model.exceptions;

public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DomainException (String msg) {
		super(msg);
	}

	//extends RuntimeException: o compilador não obriga você a tratar
	//extends Runtime: o compilador obriga você a tratar a exceção 
	
	
}
