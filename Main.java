import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cargar pacientes usando tu clase LectorArchivo
        PriorityQueueV<Paciente> cola = LectorArchivo.cargarPacientes("pacientes.txt");

        Scanner scanner = new Scanner(System.in);

        // Ciclo de atención de pacientes
        while (!cola.isEmpty()) {
            System.out.println("\nLista actual de pacientes en espera:");
            for (int i = 0; i < cola.size(); i++) {
                System.out.println((i + 1) + ". " + cola.data.get(i));
            }

            System.out.print("\n¿Atender al siguiente paciente? (S/N): ");
            String opcion = scanner.nextLine().trim().toUpperCase();

            if (opcion.equals("S")) {
                Paciente siguiente = cola.remove();
                System.out.println("\nAtendiendo a: " + siguiente);
            } else if (opcion.equals("N")) {
                System.out.println("Fin de la atención. ¡Hasta luego!");
                break;
            } else {
                System.out.println("Opción no válida. Intenta con 'S' o 'N'.");
            }
        }

        if (cola.isEmpty()) {
            System.out.println("\nTodos los pacientes han sido atendidos.");
        }

        scanner.close();
    }
}
