/**
 * Implementación de una cola de prioridad usando MinHeap y ArrayList
 * 
 * El elemento con menor prioridad se encuentra en la raíz
 * y cada nodo padre tiene una prioridad menor o igual a la de sus hijos
 * 
 * Esta implementación utiliza las operaciones siftUp y siftDown 
 * para mantener la propiedad del heap después de insertar o eliminar elementos
 * 
 * @author Valeria Hernández 25086
 */

package src;
import java.util.ArrayList;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueueInterface<E>{
    
    private ArrayList<E> data;

    public VectorHeap() {
        data = new ArrayList<>();
    }

    /**
     * Inserta un elemento en el heap y reorganiza la estructura 
     * utilizando siftUp
     * 
     * @param value elemento a insertar
     */
    @Override
    public void add(E value) {
        data.add(value);
        siftUp(data.size() - 1); //reorganiza depsués de agregar un elemento nuevo al final del ArrayList

    }

    /**
     * Reorganiza el heap moviendo un elemento hacia arriba hasta 
     * mantener la propiedad del MinHeap
     * 
     * @param index posición del elemento
     */
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


    /**
     * Elimina y retorna el elemento con mayor prioridad del heap.
     * 
     * Después de remover la raíz, el heap se reorganiza utilizando siftDown
     * 
     * @return elemento con mayor prioridad
     */
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

    /**
     * Reorganiza el heap moviendo un elemento hacia abajo 
     * hasta mantener la propiedad del MinHeap
     * 
     * @param index posición del elemento
     */
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

    /**
     * Retorna el elemento con mayor prioridad sin eliminarlo
     * 
     * @return primer elemento del heap
     */
    @Override
    public E getFirst() {
        if (isEmpty()) {
            return null;
        }

        return data.get(0);
    }

    /**
     * Verifica si el heap está vacío.
     * 
     * @return true si está vacío, false si no
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Retorna la cantidad de elementos almacenados en el heap
     * 
     * @return tamaño del heap
     */
    @Override
    public int size() {
        return data.size();
    }
}