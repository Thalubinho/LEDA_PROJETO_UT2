package structures.stack;

public class Stack implements StackIF<Integer> {
	
	private int size = 5;
	private int head = -1;
	private Integer[] data;

	public Stack(int size) {
		this.size = size;
		data = new Integer[size];
	}
	
	public Stack() {
		data = new Integer[size];
	}

	@Override
	public void push(Integer item) throws StackOverFlowException {
		if(head == data.length-1) {
			throw new StackOverFlowException();
		} else {
			data[++head] = item;
		}
	}

	@Override
	public Integer pop() throws StackUnderFlowException {
		if(isEmpty()){
			throw new StackUnderFlowException();
		} else {
			return data[head--];
		}
	}

	@Override
	public Integer top() throws StackUnderFlowException {
		if(!isEmpty()){
			return data[head];
		} else {
			throw new StackUnderFlowException();
		}
	}

	@Override
	public boolean isEmpty() {
		return head == -1;
	}

}
