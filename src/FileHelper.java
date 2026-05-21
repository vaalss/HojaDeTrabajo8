package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHelper {
    public static ArrayList<Patient> loadPatients(String fileName) {
        ArrayList<Patient> patients = new ArrayList<>();

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                String name = parts[0].trim();
                String symptom = parts[1].trim();
                char priority = parts[2].trim().charAt(0);

                Patient patient = new Patient(name, symptom, priority);
                patients.add(patient);

            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }

        return patients;
    }
}
