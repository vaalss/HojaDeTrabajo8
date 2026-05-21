/**
 * Interfaz que define el comportamiento de la cola de prioridad
 * 
 * Los elementos almacenados deben implementar
 * Comparable para permitir comparaciones
 * 
 * @author: Valeria Hernández 25086
 */

package src;
public interface PriorityQueueInterface<E extends Comparable<E>>{
    void add(E value);
    E remove();
    E getFirst(); //obtiene el elemento en el tope de la cola
    boolean isEmpty();
    int size();
}