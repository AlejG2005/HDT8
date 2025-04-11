public interface IPriorityQueue<E extends Comparable<E>> {
    void add(E value);
    E remove();
    E getFirst();
    boolean isEmpty();
    int size();
}
