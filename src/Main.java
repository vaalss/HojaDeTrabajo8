/**
 * @author: Valeria Hernández 25086
 */

package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Sistema de Emergencias");
        System.out.println("\n1. VectorHeap");
        System.out.println("2. Java PriorityQueue");
        System.out.print("Seleccione la implementación que desea utilziar: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        PriorityQueueInterface<Patient> cola = null;

        switch (opcion) {
            case 1:
                cola = QueueFactory.createQueue("heap");
                break;
            case 2:
                cola = QueueFactory.createQueue("java");
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        ArrayList<Patient> pacientes = FileHelper.loadPatients("pacientes.txt");

        for (Patient paciente : pacientes) {
            cola.add(paciente);
        }

        System.out.println("\nOrden de atención:\n");

        while (!cola.isEmpty()) { //Los imprime en el orden en que van saliendo
            System.out.println(cola.remove());
        }

        scanner.close();
    }
}