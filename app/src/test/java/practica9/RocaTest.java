package practica9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RocaTest {

    private Escenario e = new Escenario("LaRoca");
    private Posicion p = new Posicion(8, 8);

    @Test
    void testGetPosicion() {
        Roca roca = new Roca(e, p);
        Posicion posicionObtenida = roca.getPosicion();
        assertEquals(8, posicionObtenida.getRenglon());
        assertEquals(8, posicionObtenida.getColumna());
    }

    @Test
    void testSetPosicion() {
        Roca roca = new Roca(e, p);
        Posicion nuevaPosicion = new Posicion(1, 1);
        roca.setPosicion(nuevaPosicion);

        assertEquals(1, roca.getPosicion().getRenglon());
        assertEquals(1, roca.getPosicion().getColumna());
    }
}
