import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class LectorArchivo {
    public static PriorityQueue<Paciente> cargarPacientes(String archivo) {
        PriorityQueue<Paciente> cola = new PriorityQueue<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String nombre = partes[0].trim();
                    String sintoma = partes[1].trim();
                    String codigo = partes[2].trim();

                    Paciente paciente = new Paciente(nombre, sintoma, codigo);
                    cola.add(paciente);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return cola;
    }
}
