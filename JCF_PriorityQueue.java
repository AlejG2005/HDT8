import java.util.PriorityQueue;

public class JCF_PriorityQueue<E extends Comparable<E>> implements IPriorityQueue<E> {
    private PriorityQueue<E> JCFpq;

    public JCF_PriorityQueue() {
        JCFpq = new PriorityQueue<>();
    }

    @Override
    public void add(E value) {
        JCFpq.add(value);
    }

    @Override
    public E remove() {
        return JCFpq.poll();
    }

    @Override
    public E getFirst() {
        return JCFpq.peek();
    }

    @Override
    public boolean isEmpty() {
        return JCFpq.isEmpty();
    }

    @Override
    public int size() {
        return JCFpq.size();
    }

    //Este no es accesible por índice y no está ordenado AÚN, así que simplemente recorremos e imprimimos.
    @Override
    public void printQueue() {
    int i = 1;
        for (E e : JCFpq) {
            System.out.println(i + ". " + e);
            i++;
        }
    }

}
    
