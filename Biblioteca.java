import java.util.*;

/**
 * Created by Adriel on 09/07/2017.
 */
public class Biblioteca {
    public void añadeÁlbum(Album Album){
        int contador=0;
        for (Album a: biblioteca) {
            if (a.dameNombre().compareTo(Album.dameNombre())==0){
                biblioteca.set(contador,a);
            }
            contador++;
        }
        if(!biblioteca.contains(Album)){
            biblioteca.add(Album);
        }
    }
    public Album dameÁlbum(String identificador){
        for (Album a: biblioteca) {
            if (a.dameNombre().compareTo(identificador)==0){
                return a;
            }else return null;
        }
        return null;
    }
    public void eliminaÁlbum(String identificador){
        for (Album a: biblioteca) {
            if(a.dameNombre().compareTo(identificador)==0){
                biblioteca.remove(a);
            }
        }
    }

    public Set<Cancion>dameCancionesRepetidas(){
        ArrayList<Cancion> cancionesAlbum = new ArrayList<>();
        ArrayList<Cancion> canciones2 = new ArrayList<>();
        Map<String,Integer> mapa = new HashMap<>();

        Set<Cancion>setCanciones = new TreeSet<>(new Comparator<Cancion>() {
            @Override
            public int compare(Cancion o1, Cancion o2) {
                return o1.dameTítulo().compareTo(o2.dameTítulo());
            }
        });

        for (Album a: biblioteca) {
            cancionesAlbum=a.dameCanciones();
            for (Cancion c:cancionesAlbum) {
                canciones2.add(c);
                if(!mapa.containsKey(c.dameTítulo())){
                    mapa.put(c.dameTítulo(),1);
                }else if(mapa.containsKey(c.dameTítulo())){
                    mapa.put(c.dameTítulo(),mapa.get(c.dameTítulo())+1);
                }
            }
        }
        //En cancion 2 estan todas las canciones (Comprobado)
        for (String key: mapa.keySet()) {
            if (mapa.get(key)>1){
                for (Cancion c: canciones2) {
                    if (key.compareTo(c.dameTítulo())==0)
                        setCanciones.add(c);
                }
            }
        }
        return setCanciones;
    }

    public List<String> dameIntérpretes(){
        ArrayList<Cancion> cancionesAlbum = new ArrayList<>();
        ArrayList<String> cancionesString = new ArrayList<>();

        Map<String,Integer> mapa= new HashMap<>();
        for (Album a: biblioteca) {
            cancionesAlbum=a.dameCanciones();
            for (Cancion c:cancionesAlbum) {
                if(!mapa.containsKey(c.dameIntérprete())){
                    mapa.put(c.dameIntérprete(),1);
                }else if(mapa.containsKey(c.dameIntérprete())){
                    mapa.put(c.dameIntérprete(),mapa.get(c.dameIntérprete())+1);
                }
            }
        }
        List<Map.Entry<String,Integer>>lista= new LinkedList<Map.Entry<String, Integer>>(mapa.entrySet());
        Collections.sort(lista, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().compareTo(o2.getValue())==0){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String,Integer> item:lista) {
            cancionesString.add(item.getKey()+": "+item.getValue());
        }
        return cancionesString;

    }

    public String toString(){
        int duracion =0;
        String res= "";
        for (Album a: biblioteca) {
            res+=a.toString()+"\n";
        }
        return "Los Albumes de la Biblioteca son: \n"+res;
    }
    ArrayList<Album> biblioteca = new ArrayList<>();
}
