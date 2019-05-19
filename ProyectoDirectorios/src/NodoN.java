import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class NodoN<Directorio extends Comparable<Directorio>> {
	protected Directorio llave;
	ArrayList<NodoN<Directorio>> hijos;
	protected NodoN<Directorio> padre;
	public NodoN() {
		this.llave=llave;
		padre=null;
		hijos=new ArrayList<NodoN<Directorio>>();
	}

	public NodoN(int n) {
		this.llave=llave;
		padre=null;
		hijos=new ArrayList<NodoN<Directorio>>();
	}


	public NodoN(Directorio llave, ArrayList hijos, NodoN<Directorio> padre) {
		this.llave = llave;
		this.hijos = hijos;
		this.padre = padre;
	}

	//getts & setts (Ademas hice un metodo para agregar hijos a un nodo y para pedir un hijo en una
	//posicion del arreglo de hijos).

	public Directorio getLlave() {
		return llave;
	}

	public void setLlave(Directorio llave) {
		this.llave = llave;
	}

	public ArrayList getHijos() {
		return hijos;
	}

	public void addHijo(NodoN<Directorio> hijo) {
		this.hijos.add(hijo);
	}

	public  NodoN findHijo(int posicion){
		return this.hijos.get(posicion);
	}

	public NodoN<Directorio> getPadre() {
		return padre;
	}

	public void setPadre(NodoN<Directorio> padre) {
		this.padre = padre;
	}
}
