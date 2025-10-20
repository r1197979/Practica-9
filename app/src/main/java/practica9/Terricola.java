package practica9;

public class Terricola extends Personaje{
    
    public Terricola(Escenario e, Posicion p, String n){
        super(e,p,n);

    }

    public String destruir(){
        return "Terricola destruido";
    }
}
