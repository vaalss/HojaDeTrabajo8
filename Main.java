import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        VectorHeap<Patient> cola = new VectorHeap<>();

        ArrayList<Patient> pacientes =
                FileHelper.loadPatients("pacientes.txt");

        for (Patient paciente : pacientes) {
            cola.add(paciente);
        }

        System.out.println("Orden de atención:");

        while (!cola.isEmpty()) {
            System.out.println(cola.remove());
        }
    }
}