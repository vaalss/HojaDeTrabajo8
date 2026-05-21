package src.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.Patient;
import src.VectorHeap;

public class VectorHeapTest {

    @Test
    public void addAndRemove() {

        VectorHeap<Patient> heap = new VectorHeap<>();
        heap.add(new Patient("Juan", "Fractura", 'C'));
        heap.add(new Patient("Maria", "Apendicitis", 'A'));
        heap.add(new Patient("Pedro", "Fiebre", 'B'));


        Patient first = heap.remove();
        assertEquals('A', first.getPriority());
        Patient second = heap.remove();
        assertEquals('B', second.getPriority());
        Patient third = heap.remove();
        assertEquals('C', third.getPriority());
    }

    @Test
    public void isEmpty() {

        VectorHeap<Patient> heap = new VectorHeap<>();
        assertTrue(heap.isEmpty());
        heap.add(new Patient("Juan","Fractura",'C'));
        assertFalse(heap.isEmpty());
    }

    @Test
    public void size() {

        VectorHeap<Patient> heap = new VectorHeap<>();
        assertEquals(0, heap.size());
        heap.add(new Patient("Juan", "Fractura",'C'));
        heap.add(new Patient("Maria","Apendicitis",'A'));
        assertEquals(2, heap.size());
    }

    @Test
    public void getFirst() {

        VectorHeap<Patient> heap = new VectorHeap<>();
        heap.add(new Patient("Juan","Fractura",'C'));
        heap.add(new Patient("Maria","Apendicitis",'A'));
        Patient first = heap.getFirst();
        assertEquals('A', first.getPriority());
    }
}
