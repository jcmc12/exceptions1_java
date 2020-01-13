package model.exceptions;

public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DomainException (String msg) {
		super(msg);
	}

	//extends RuntimeException: o compilador n�o obriga voc� a tratar
	//extends Runtime: o compilador obriga voc� a tratar a exce��o 
	
	
}
