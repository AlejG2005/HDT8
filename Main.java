import java.util.Scanner;

public class Main {
    //Preguntamos al usuario si quiere utlizar la implementación por vectores o la del JCF. Llama al factory y lo instancia.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n¿Qué implementación deseas usar? \n 1. VectorPriorityQueue \n 2. JCF PriorityQueue");
        int opcion = Integer.parseInt(scanner.nextLine());

        IPriorityQueue<Paciente> cola = Decider.getQueue(opcion);
        LectorArchivo.cargarPacientes("pacientes.txt", cola);

        while (!cola.isEmpty()) {
            System.out.println("\nLista actual de pacientes en espera:");
            cola.printQueue();

            System.out.print("\n¿Atender al siguiente paciente? (S/N): ");
            String resp = scanner.nextLine().trim().toUpperCase();

            if (resp.equals("S")) {
                Paciente p = cola.remove();
                System.out.println("\nAtendiendo a: " + p);
            } else if (resp.equals("N")) {
                System.out.println("\nFin de la atención. ¡Hasta luego!");
                break;
            } else {
                System.out.println("\nOpción no válida.");
            }
        }

        if (cola.isEmpty()) {
            System.out.println("\nTodos los pacientes han sido atendidos.");
        }

        scanner.close();
    }
}
