package structures.stack;

import java.io.Serial;

public class StackUnderFlowException extends Exception {
	
	@Serial
	private static final long serialVersionUID = -2959856106469842073L;

	public StackUnderFlowException() {
		super("pilha vazia!!");
	}
	
	public StackUnderFlowException(String message) {
		super(message);
	}

}
