package structures.hash;

import interfaces.HasKey;
import structures.linked_list.LinkedList;

public class HashTable <T extends HasKey & Comparable<T>>   {
    private LinkedList<T>[] table;
    private final int size;

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        this.table = (LinkedList<T>[]) new LinkedList[size];
        this.size = size;
    }

    private int hash(T object) {
        return object.getKey() % this.size;
    }

    public void add(T object) {
        int hash = hash(object);
        table[hash].add(object);
    }

    public T remove(T object) {
        int hash = hash(object);
        return this.table[hash].remove(object);
    }

}
