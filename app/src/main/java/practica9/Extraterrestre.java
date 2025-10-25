package practica9;

public class Extraterrestre extends Personaje{

    public Extraterrestre(Escenario e, Posicion p, String nombre){
        super(e,p,nombre);
    }

    
    @Override
    public String destruir(){
        return "Alien destruido!";
    }

    @Override
    public String toString() {
    return "Extraterrestre " + posicion.getRenglon() + " " + posicion.getColumna() + " " + nombre;
}
}