package practica9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ExtraterrestreTest {

    private Escenario e = new Escenario("Marte");
    private Posicion p = new Posicion(5, 5);
    private String nombre = "Alien";

    @Test
    void testDestruir() {
        Extraterrestre alien = new Extraterrestre(e, p, nombre);
        String resultado = alien.destruir();
        assertEquals("Alien destruido!", resultado);
     }
}
