package practica9;

public class Posicion {
    
    private int renglon;
    private int columna;

    public Posicion(int r, int c){
        renglon = r;
        columna= c;
    }

    public int getRenglon(){
        return renglon;
    }
    public int getColumna(){
        return columna;
    }
}
