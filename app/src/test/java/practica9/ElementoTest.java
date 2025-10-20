package practica9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ElementoTest {

    private Escenario e = new Escenario("Base");
    private Posicion pInicial = new Posicion(5, 5);
    private Posicion pNueva = new Posicion(1, 9);
    Elemento elemento = new Elemento(e, pInicial) {
    };

    @Test
    void testGetPosicion() {
        Posicion posicionObtenida = elemento.getPosicion();
        assertEquals(5, posicionObtenida.getRenglon());
        assertEquals(5, posicionObtenida.getColumna());
    }

    @Test
    void testSetPosicion() {
        elemento.setPosicion(pNueva);
        assertEquals(1, elemento.getPosicion().getRenglon());
        assertEquals(9, elemento.getPosicion().getColumna());
    }
}
