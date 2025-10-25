package practica9;

import java.util.Scanner;

public class MisionPosibleMain {

    public static void main(String[] args){
        
        Scanner sc= new Scanner(System.in);
        String archivo= "archivoConfiguracion";

        
        System.out.println("Posicion roca X: ");
        int bX= sc.nextInt();
        System.out.println("Posicion roca Y: ");
        int bY= sc.nextInt();


        Escenario e= new Escenario("Nostromo");
        e.agregarElemento(new Terricola(e,new Posicion(3,2),"Ripley"));
        e.agregarElemento(new Extraterrestre(e,new Posicion(3,5),"Alien"));
        e.agregarElemento(new Roca(e,new Posicion(4,3)));

        Bomba b= new Bomba(e, new Posicion(4,4),2);
        e.agregarElemento(b);
        System.out.println(e);
        b.explotar();
        System.out.println();
        System.out.println(e);
        
    }

}
