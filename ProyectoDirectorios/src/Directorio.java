
public class Directorio implements Comparable {
    public String nombre;
    public String ruta;
    public double peso; //Esto si hace falta?

    public Directorio(double peso) { //Creo este constructo para probar algunos metodos
        this.peso = peso;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
