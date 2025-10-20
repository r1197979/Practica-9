package practica9;

public class Elemento {
    
    protected Posicion posicion;
    protected Escenario escenario;

    public Elemento(Escenario c, Posicion p){
        posicion = p;
        escenario= c;
    }

    public Posicion getPosicion(){
        return posicion;
    }
    public void setPosicion(Posicion p){
        posicion= p;
    }
}
