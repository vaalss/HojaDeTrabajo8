import java.util.ArrayList;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>{
    
    private ArrayList<E> data;

    public VectorHeap() {
        data = new ArrayList<>();
    }

    @Override
    public void add(E value) {
        data.add(value);
        siftUp(data.size() - 1);

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
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        E root = data.get(0);

        if (data.size() == 1) {
            data.remove(0);
            return root;
        }

        E last = data.remove(data.size() - 1);
        data.set(0, last);
        siftDown(0);

        return root;
    }

    private void siftDown(int index) {
        int size = data.size();
        boolean continuar = true;

        while (continuar) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            int min = index;

            if (left < size && data.get(left).compareTo(data.get(min)) < 0) {
                min = left;
            }

            if (right < size && data.get(right).compareTo(data.get(min)) < 0) {
                min = right;
            }

            if (min == index) {
                continuar = false;
            } else {
                E temp = data.get(index);
                data.set(index, data.get(min));
                data.set(min, temp);

                index = min;
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