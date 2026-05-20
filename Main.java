public class Main {

    public static void main(String[] args) {

        VectorHeap<Patient> cola = new VectorHeap<>();

        cola.add(new Patient("Juan","Fractura de pierna",'C'));

        cola.add(new Patient("Maria","Apendicitis",'A'));

        cola.add(new Patient("Josúe","Sarampión",'E'));

        cola.add(new Patient("Carmen","Dolores de parto", 'B'));

        System.out.println("Orden de atención:");
        while (!cola.isEmpty()) {
            System.out.println(cola.remove());
        }
    }
}