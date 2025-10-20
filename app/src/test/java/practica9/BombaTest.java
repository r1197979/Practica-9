package practica9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class BombaTest {

    private Escenario escenario = new Escenario("Relleno");
    private Posicion posicion = new Posicion(0, 0);

    @Test
    void testDestruir() {
        Bomba bomba = new Bomba(escenario, posicion, 1);
        String resultado = bomba.destruir();
        assertEquals("Bomba destruida", resultado);
    }

    @Test
    void testExplotar() {
        Bomba bomba = new Bomba(escenario, posicion, 1);
        bomba.explotar();
        assertTrue(true);
    }
}
