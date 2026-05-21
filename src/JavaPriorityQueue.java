package src;

import java.util.PriorityQueue;

public class JavaPriorityQueue<E extends Comparable<E>> implements PriorityQueueInterface<E> {
    
    private PriorityQueue<E> queue;

    public JavaPriorityQueue() {
        queue = new PriorityQueue<>();
    }

    @Override
    public void add(E value) {
        queue.add(value);
    }

    @Override
    public E remove() {
        return queue.poll();
    }

    @Override
    public E getFirst() {
        return queue.peek();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }

}
