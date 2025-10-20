package practica9;

import java.util.ArrayList;

public class Escenario {
    
    String nombre;
    Elemento[][] campoDeBatalla= new Elemento[10][10];


    public Escenario(String nombre){
        this.nombre= nombre;
    }



    public void agregarElemento(Elemento e){
        Posicion p= e.getPosicion();
        int r=p.getRenglon();
        int c= p.getColumna();

        campoDeBatalla[r][c]= e;
    }



    public void destruirElementos(Posicion p, int radio){

        int bombaRenglon= p.getRenglon();
        int bombaColumna= p.getColumna();

        ArrayList<Elemento> elementosAlrededor= new ArrayList<>();

        for(int i=0; i<campoDeBatalla.length; i++){
            for(int j=0; j<campoDeBatalla.length; j++){

                int distanciaR;
                if(i>bombaRenglon){
                    distanciaR= i-bombaRenglon;
                }else{
                    distanciaR= bombaRenglon-i;
                }

                int distanciaC;
                if(j>bombaColumna){
                    distanciaC= j- bombaColumna;
                }else{
                    distanciaC= bombaColumna-j;
                }

                int distanciaTotal= distanciaR+distanciaC;

                if(distanciaTotal <=radio){
                    Elemento e= campoDeBatalla[i][j];
                    if(e!=null){
                        elementosAlrededor.add(e);
                    }
                }
            }
        }

        for(Elemento e: elementosAlrededor){

            if(e instanceof Destruible){

                System.out.println( ((Destruible) e).destruir() );

                Posicion posicion= e.getPosicion();
                int px= posicion.getRenglon();
                int py= posicion.getColumna();
                campoDeBatalla[px][py]= null;
            }
        }
    }



    public String toString(){
        
        String matriz= "";

        for(int i=0; i<campoDeBatalla.length; i++){
            for(int j=0; j<campoDeBatalla.length; j++){

                Elemento e= campoDeBatalla[i][j];

                if(e==null){
                    matriz+= " 0 ";
                }else if(e instanceof Terricola){
                    matriz+= " T ";
                }else if(e instanceof Roca){
                    matriz+= " R ";
                }else if(e instanceof Bomba){
                    matriz+= " B ";
                }else if (e instanceof Extraterrestre){
                    matriz+= " E ";
                }

            }
            matriz+= "\n";
        }
        return matriz;
    }
}
