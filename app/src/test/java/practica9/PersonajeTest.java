package practica9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PersonajeTest {
    private Escenario e = new Escenario("Espacio");
    private Posicion p = new Posicion(7, 3);
    private String nombre = "Tom";

    @Test
    void testDestruir() {
        Personaje personaje = new Personaje(e, p, nombre);
        String resultado = personaje.destruir();
        assertEquals("Personaje destruido", resultado);
    }

    @Test
    void testGetNombre() {
        Personaje personaje = new Personaje(e, p, nombre);
        String nombreObtenido = personaje.getNombre();
        assertEquals(nombre, nombreObtenido);
    }
}
