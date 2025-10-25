package practica9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Escenario {
    
    String nombre;
    Elemento[][] campoDeBatalla= new Elemento[10][10];
    private static final int DIMENSION= 10;


    public Escenario(String nombre){
        this.nombre= nombre;
    }



    public void agregarElemento(Elemento e){
        Posicion p= e.getPosicion();
        int r=p.getRenglon();
        int c= p.getColumna();

        campoDeBatalla[r][c]= e;
    }



    public void removeElemento(Elemento elemento) {
        Posicion p = elemento.getPosicion();
        if (p.getRenglon() >= 0 && p.getRenglon() < DIMENSION && p.getColumna() >= 0 && p.getColumna() < DIMENSION) {
            this.campoDeBatalla[p.getRenglon()][p.getColumna()] = null;
        }
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



    public ArrayList<Bomba> getBombas() {
        ArrayList<Bomba> bombasEncontradas = new ArrayList<>();
        
        for (int i = 0; i < campoDeBatalla.length; i++) {
            for (int j = 0; j < campoDeBatalla[i].length; j++) {
                
                Elemento e = campoDeBatalla[i][j];
                
                if (e instanceof Bomba) {
                    bombasEncontradas.add((Bomba) e);
                }
            }
        }
        return bombasEncontradas;
    }


    public void guardarConfiguracion(String nombreArchivo) {
        BufferedWriter escritorBuffer = null;
        try {
            escritorBuffer = new BufferedWriter(new FileWriter(nombreArchivo));
        
            for (int i = 0; i < DIMENSION; i++) {
                for (int j = 0; j < DIMENSION; j++) {
                    Elemento e = campoDeBatalla[i][j];
                    
                    if (e != null) {
                        escritorBuffer.write(e.toString()); 
                        escritorBuffer.newLine(); 
                    }
                }
            }
            System.out.println("Configuración guardada en: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("ERROR al escribir en el archivo: " + e.getMessage());
        } finally {
            if (escritorBuffer != null) {
                try {
                    escritorBuffer.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
    }



    public void cargarConfiguracion(String nombreArchivo) {
        BufferedReader lectorBuffer = null;
        
        try {
            lectorBuffer = new BufferedReader(new FileReader(nombreArchivo));
            String linea;

            while ((linea = lectorBuffer.readLine()) != null) {
                
                String[] partes = linea.split(" "); 
                
                if (partes.length < 3) continue;

                String tipo = partes[0];
                int r = Integer.parseInt(partes[1]);
                int c = Integer.parseInt(partes[2]);
                Posicion p = new Posicion(r, c);
                Elemento nuevo = null;

                if (tipo.equals("Roca")) {
                    nuevo = new Roca(this, p);
                } else if (tipo.equals("Terricola")) {
                    String nombreT;
                    if (partes.length > 3) {
                        nombreT = partes[3];
                    } else {
                        nombreT = "Humano";
                    }
                    nuevo = new Terricola(this, p, nombreT);
                } else if (tipo.equals("Extraterrestre")) {
                    String nombreE;
                    if (partes.length > 3) {
                        nombreE = partes[3];
                    } else {
                        nombreE = "AlienX";
                    }
                    nuevo = new Extraterrestre(this, p, nombreE);
                } else if (tipo.equals("Bomba") && partes.length >= 4) {
                    int radio = Integer.parseInt(partes[3]);
                    nuevo = new Bomba(this, p, radio);
                }
                
                if (nuevo != null) {
                    this.agregarElemento(nuevo);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("ADVERTENCIA: Archivo de configuración no encontrado. Se inicia escenario vacío.");
        } catch (IOException e) {
            System.out.println("ERROR de lectura de archivo: " + e.getMessage());
        } finally {
            if (lectorBuffer != null) {
                try {
                    lectorBuffer.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
    }
}
