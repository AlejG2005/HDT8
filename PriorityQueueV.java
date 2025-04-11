import java.util.Vector;

/* Clase que contiene la implementación de una priority queue con vectores. */
public class PriorityQueueV<E extends Comparable<E>> implements IPriorityQueue<E> {
    protected Vector<E> data;

    public PriorityQueueV() {
        data = new Vector<E>();
    }

    @Override
    // Agrega un elemento y lo coloca en la posición correcta.
    public void add(E value) {
        data.add(value);
        subir(data.size() - 1);
    }

    @Override
    // Devuelve la raíz del heap, la prioridad más alta.
    public E getFirst() {
        return data.get(0);
    }

    @Override
    // Elimina o saca la raíz reemplazandola con el último 
    public E remove() {
        if (data.isEmpty()) return null;

        E minVal = data.get(0);
        E lastVal = data.remove(data.size() - 1);

        if (!data.isEmpty()) {
            data.set(0, lastVal);
            bajar(0);
        }

        return minVal;
    }

    @Override
    //Devuelve si la cola está vacía.
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //Devuelve el tamaño de la cola.
    @Override
    public int size() {
        return data.size();
    }

    //Nos aprovechamos que es accesible por índice y recorremos toda la cola para irla imprimiendo.
    @Override
    public void printQueue(){
        for (int i = 0; i < data.size(); i++) {
            System.out.println((i + 1) + ". " + data.get(i));
        }
    }

    //Subir es el método auxiliar que verifica si es menor que su padre, de serlo los intercambia. 

    protected void subir(int i) {
        int parent = (i - 1) / 2;
        E value = data.get(i);

        while (i > 0 && value.compareTo(data.get(parent)) < 0) {
            data.set(i, data.get(parent));
            i = parent;
            parent = (i - 1) / 2;
        }

        data.set(i, value);
    }

    //Bajar es el método auxiliar que verifica si es mayor que alguno de sus hijos, de serlo los intercambia. 

    protected void bajar(int i) {
        int child;
        E value = data.get(i);

        while (i * 2 + 1 < data.size()) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;

            // Encuentra el hijo menor
            child = left;
            if (right < data.size() && data.get(right).compareTo(data.get(left)) < 0) {
                child = right;
            }

            if (data.get(child).compareTo(value) >= 0) break;

            data.set(i, data.get(child));
            i = child;
        }

        data.set(i, value);
    }
}

