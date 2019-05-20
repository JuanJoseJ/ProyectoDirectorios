public class Directorio implements Comparable<Directorio>{

    private String nombre;
    private String ruta;
    private double peso;

    public Directorio(String nombre, String ruta, double peso) {
        super();
        this.nombre = nombre;
        this.ruta = ruta;
        this.peso = peso;
    }

    public Directorio() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Directorio(double peso) { //Creo este constructo para probar algunos metodos
        this.peso = peso;
    }
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public int compareTo(Directorio o) {
        // TODO Auto-generated method stub
        if(this.nombre.compareTo(o.getNombre())==0) {
            if(this.peso<o.getPeso())
                return -1;
            else if(this.peso>o.getPeso())
                return 1;
            return 0;
        }else {
            return (this.nombre.compareTo(o.getNombre()));
        }

    }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nombre;
	}
    
    

}
