package structures.linked_list;

public class Node<T extends Comparable<T>> {
    protected T data;
    protected Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

}
