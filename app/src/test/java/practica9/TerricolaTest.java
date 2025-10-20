package practica9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TerricolaTest {

    private Escenario e = new Escenario("Tierra");
    private Posicion p = new Posicion(2, 2);
    private String nombre = "Ripley";

    @Test
    void testDestruir() {
        Terricola terricola = new Terricola(e, p, nombre);
        String resultado = terricola.destruir();
        assertEquals("Terricola destruido", resultado);
    }
}
