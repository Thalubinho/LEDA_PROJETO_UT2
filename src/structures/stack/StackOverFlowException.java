package structures.stack;

import java.io.Serial;

public class StackOverFlowException extends Exception {
	
	@Serial
	private static final long serialVersionUID = 1L;

	public StackOverFlowException() {
		super("pilha cheia!");
	}
	
}
