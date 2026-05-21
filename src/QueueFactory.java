package src;

public class QueueFactory {
    public static<E extends Comparable<E>> PriorityQueueInterface<E> createQueue(String type) {
        if (type.equalsIgnoreCase("heap")) {
            return new VectorHeap<>();
        } else if (type.equalsIgnoreCase("java")) {
            return new JavaPriorityQueue<>();
        } else {
            return null;
        }
    }
}
