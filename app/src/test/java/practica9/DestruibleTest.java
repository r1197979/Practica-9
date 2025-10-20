package practica9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DestruibleTest {
    @Test
    void testDestruir() {

        Destruible objetoDestruible = new Destruible() {
            @Override
            public String destruir() {
                // Implementamos el método con un String de prueba.
                return "Contrato Cumplido";
            }
        };
        String resultado = objetoDestruible.destruir();
        assertEquals("Contrato Cumplido", resultado);
        assertTrue(objetoDestruible instanceof Destruible);
    }
}
