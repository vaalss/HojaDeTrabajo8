package src;
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