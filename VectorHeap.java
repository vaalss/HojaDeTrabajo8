import java.util.ArrayList;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>{
    
    private ArrayList<E> data;

    public VectorHeap() {
        data = new ArrayList<>();
    }

    @Override
    public void add(E value) {
        data.add(value);

    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            E current = data.get(index);
            E parentValue = data.get(parent);

            if (current.compareTo(parentValue) < 0) { //si el actual tiene mayor prioridad que su padre, se intercambian
                data.set(index, parentValue);
                data.set(parent, current);

                index = parent;
            } else {
                break;
            }
        }
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            return null;
        }

        return data.get(0);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }
}