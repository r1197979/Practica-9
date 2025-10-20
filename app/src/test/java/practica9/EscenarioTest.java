package practica9;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EscenarioTest {

    private Escenario e;
    private Posicion pBomba = new Posicion(5, 5);
    private final int RADIO = 2;

    @BeforeEach
    void setUp() {
        e = new Escenario("TestZone");
    }

    @Test
    void testAgregarElemento() {
        Posicion p = new Posicion(1, 1);
        Elemento elemento = new Elemento(e, p) {}; 
        e.agregarElemento(elemento);
        assertNotNull(e.campoDeBatalla[1][1]);
    }

    @Test
    void testDestruirElementos() {

        Terricola destruibleLimite = new Terricola(e, new Posicion(3, 5), "Target");
        Roca noDestruible = new Roca(e, new Posicion(4, 5));
        Terricola fueraDeRadio = new Terricola(e, new Posicion(2, 5), "Lejos");

        e.agregarElemento(destruibleLimite);
        e.agregarElemento(noDestruible);
        e.agregarElemento(fueraDeRadio);
        e.destruirElementos(pBomba, RADIO);

        assertNull(e.campoDeBatalla[3][5]);
        assertNotNull(e.campoDeBatalla[4][5]);
        assertNotNull(e.campoDeBatalla[2][5]);
    }

    @Test
    void testToString() {
        String representacion = e.toString();
        assertNotNull(representacion);
        assertTrue(representacion.contains("\n"));
    }
}
