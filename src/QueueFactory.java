/**
 * Fábrica encargada de crear distintas implementaciones de colas con prioridad
 * 
 * Permite seleccionar entre la implementación propia basada en 
 * Heap y la implementación del Java Collection Framework
 * 
 * @author Valeria Hernández 25086
*/

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
