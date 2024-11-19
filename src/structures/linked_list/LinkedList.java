package structures.linked_list;

public class LinkedList<T extends Comparable<T>> {
    protected Node<T> head;

    public LinkedList(){
        this.head = null;
    }

    public void add(T value){
        Node<T> newNode = new Node<>(value);
        Node<T> temp = head.next;
        head.next = newNode;
        newNode.next = temp;
    }

    public T remove(T object){
        Node<T> temp = head;
        T result = null;
        while(temp != null && result == null){
            if(temp.next.data.compareTo(object) == 0){
                result = temp.next.data;
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        return result;
    }

    public boolean contains(T object){
        Node<T> temp = head;
        boolean result = false;
        while(temp != null && !result){
            if(temp.data.compareTo(object) == 0){
                result = true;
            }
        }

        return result;
    }
}
