import java.util.ArrayList;

/**
 * Created by Adriel on 09/07/2017.
 */
public class Album {
    public Album(String identificador){
        this.identificador=identificador;
    }
    public String dameNombre(){
        return identificador;
    }
    public int numeroDeCanciones(){
        return canciones.size();
    }
    public Cancion dameCanción(int posicion){
        return canciones.get(posicion);
    }
    public void añadeCanción(Cancion cancion){
        canciones.add(cancion);
    }
    public void quitaCanción(Cancion cancion){
        canciones.remove(cancion);
    }
    public int duracion(){
        for (Cancion c: canciones) {
            duracion+=c.dameDuración();
        }
        return duracion;
    }
    public String toString(){
        int contador=1;
        String resultado="";
        for (Cancion c: canciones) {
            resultado+=contador+") "+c.toString()+"\n";
            contador++;
        }
        return this.identificador+": \n"+resultado;
    }
    public ArrayList<Cancion> dameCanciones(){
        return canciones;
    }


    private ArrayList<Cancion> canciones = new ArrayList<>();
    private String identificador="";
    private int duracion;
}
