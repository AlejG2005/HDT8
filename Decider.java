public class Decider {
    public static <E extends Comparable<E>> IPriorityQueue<E> getQueue(int opcion) {
        switch (opcion) {
            case 1:
                return new PriorityQueueV<>();
            case 2:
                return new JCF_PriorityQueue<>();
            default:
                System.out.println("Opción no existe, usando JCF Priority Queue por defecto.");
                return new JCF_PriorityQueue<>();
            }
        }
    }