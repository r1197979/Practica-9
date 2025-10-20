package practica9;


public class Bomba extends Elemento implements Destruible{
    private int radio;

    public Bomba(Escenario e, Posicion p, int r){
        super(e,p);
        radio= r;
    }

    @Override
    public String destruir(){
        return "Bomba destruida";
    }

    public void explotar(){
        System.out.println("Explotando bomba!");
        escenario.destruirElementos(posicion, radio);
    }
}
