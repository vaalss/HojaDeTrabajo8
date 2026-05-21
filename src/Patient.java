package src;

/**
 * Representa un paciente dentro del sistema de emergencias
 * 
 * Cada paciente tiene un nombre, un síntoma y una prioridad
 * Donde A tiene mayor prioridad que B, y así sucesivamente
 * 
 * La clase implementa la interfaz Comparable para permitir la comparación de prioridades
 * 
 * @author Valeria Hernández 25086
 */

public class Patient implements Comparable<Patient>{
    private String name;
    private String symptom;
    private char priority;

    public Patient(String name, String symptom, char priority) {
        this.name = name;
        this.symptom = symptom;
        this.priority = priority;
    }

    public String getName() {
        return this.name;
    }

    public String getSymptom() {
        return this.symptom;
    }

    public char getPriority() {
        return this.priority;
    }

    @Override
    public int compareTo(Patient other) {
        return this.priority - other.priority; //comparar los caracteres ASCII, A < B (A tiene mayor prioridad)
    }

    @Override
    public String toString() {
        return name + ", " + symptom  + ": " + priority;
    }

}