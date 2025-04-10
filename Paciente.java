/*Clase paciente que se encarga de formar al objeto paciente. Este está compuesto por su nombre, la descrición del síntoma que tiene
 * y el nivel de prioridad que tiene su síntoma.
 */
public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String descripcionSintoma;
    private String nivelEmergencia;
    private static int contador = 0;
    private int idLlegada;

    //Constructor de la clase.
    public void paciente(String nombre, String descripcionSintoma, String nivelEmergencia){
        this.nombre = nombre;
        this.descripcionSintoma = descripcionSintoma;
        this.nivelEmergencia = nivelEmergencia;
        this.idLlegada = contador++;
    }

    //getters de el objeto.
    public String getNombre() {
        return nombre;
    }
    public String getSintoma() {
        return descripcionSintoma;
    }
    public String getCodigoEmergencia() {
        return nivelEmergencia;
    }

    /* Modificamos el método de comparetTo para luego poder definir prioridades más altas. Este recibe un objeto Paciente y llama
     * al compareTo de java que va a comparar con la prioridad del paciente actual. Si es mayor devuelve 1, si es menor -1 y si es igual
     * 0. Entonces, para el caso en el que son iguales mandamos a verificar cuál de ellos llegó primero, mediante otra llamada al
     * compareTo para enteros.
     */
    @Override
    public int compareTo(Paciente paciente){
        int prioritario = this.nivelEmergencia.compareTo(paciente.nivelEmergencia);

        if (prioritario != 0){
            return prioritario;
        } else {
            return Integer.compare(this.idLlegada, paciente.idLlegada);
        }
    }

    /* Modificamos el toString para que cuando se devuelva un objeto del tipo Paciente sea ordenado, de la forma: 
    nombre, sintoma, prioridad. */
    @Override
    public String toString(){
        return nombre + ", " + descripcionSintoma + ", " + nivelEmergencia;
    }

}
