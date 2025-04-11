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
}
    
