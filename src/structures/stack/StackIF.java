package structures.stack;

public interface StackIF<E> {
	
	void push(E item) throws StackOverFlowException;
	
	E pop() throws StackUnderFlowException;
	
	E top() throws StackUnderFlowException;

	boolean isEmpty();

}
