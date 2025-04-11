// Clase que lee y separa los distintos pacientes. Utiliza BufferedReader 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/* Contiene como método cargarPacientes que lee el archivo línea por línea y va partiendo un string cada que encuentra una coma ','
 También solamente acepta 'Nombre, síntoma, grado', de ser mayor o menor no lo toma en cuenta. Luego crea un objeto del tipo paciente
 y lo agrega a la cola de prioridad.*/
public class LectorArchivo {
    public static PriorityQueueV<Paciente> cargarPacientes(String archivo) {
        PriorityQueueV<Paciente> cola = new PriorityQueueV<>();

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
