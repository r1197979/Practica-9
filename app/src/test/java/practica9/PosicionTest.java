package practica9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PosicionTest {

    private final int pruebaR = 4;
    private final int pruebaC = 9;
    private Posicion p = new Posicion(pruebaR, pruebaC);

    @Test
    void testGetColumna() {
        assertEquals(pruebaC, p.getColumna());
    }

    @Test
    void testGetRenglon() {
        assertEquals(pruebaR, p.getRenglon());
    }
}
