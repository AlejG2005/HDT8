/*Interfaz que será útil para el patrón factory. Aquí están todos los métodos obligatorios que cada PriorityQueue debe tener.
 * Add añade un objeto a la cola, remove elimina la raíz, getFirst devuelve la raíz, isEmpty verifica sí está vacía, size devuelve
 * su tamaño y printQueue nos muestra su estado actual.
*/
public interface IPriorityQueue<E extends Comparable<E>> {
    void add(E value);
    E remove();
    E getFirst();
    boolean isEmpty();
    int size();
    void printQueue();
}
