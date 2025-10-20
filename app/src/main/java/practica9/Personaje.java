package practica9;

public class Personaje extends Elemento implements Destruible{
    
    protected String nombre;
    protected int puntosDeVida;

    public Personaje(Escenario e, Posicion p, String nombre){
        super(e,p);
        this.nombre= nombre;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public String destruir(){
        return "Personaje destruido";
    }
}
