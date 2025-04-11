import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VectorTesting {
    private PriorityQueueV<Paciente> heap;

    @BeforeEach
    public void setUp() {
        heap = new PriorityQueueV<>();
    }

    @Test
    public void testAdd() {
        Paciente p1 = new Paciente("Ana", "fiebre", "C");
        Paciente p2 = new Paciente("Ben", "fractura", "B");
        Paciente p3 = new Paciente("Carlos", "dolor pecho", "A");

        heap.add(p1);
        heap.add(p2);
        heap.add(p3);

        //Verificamos que Carlos (A) sí esté al frente.
        assertEquals(p3, heap.getFirst());
        assertEquals(3, heap.size());
    }

    @Test
    public void testRemove() {
        Paciente p1 = new Paciente("Ana", "fiebre", "C");
        Paciente p2 = new Paciente("Ben", "fractura", "B");
        Paciente p3 = new Paciente("Carlos", "dolor pecho", "A");

        heap.add(p1);
        heap.add(p2);
        heap.add(p3);

        //Confirmamos que se retiran en orden de prioridad, además que la pila quedé vacía.
        assertEquals(p3, heap.remove()); // Carlos (A)
        assertEquals(p2, heap.remove()); // Ben (B)
        assertEquals(p1, heap.remove()); // Ana (C)
        assertTrue(heap.isEmpty());
    }
}
