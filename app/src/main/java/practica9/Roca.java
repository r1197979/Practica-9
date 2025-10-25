package practica9;

public class Roca extends Elemento{
    
    public Roca(Escenario e, Posicion p){
        super(e,p);
    }

    public String toString() {
    return "Roca " + posicion.getRenglon() + " " + posicion.getColumna();
}
}
