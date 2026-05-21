package src;
public interface PriorityQueueInterface<E extends Comparable<E>>{
    void add(E value);
    E remove();
    E getFirst();
    boolean isEmpty();
    int size();
}