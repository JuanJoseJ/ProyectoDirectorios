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

	public NodoN(Directorio llave, ArrayList hijos, NodoN<Directorio> padre) {
		this.llave = llave;
		this.hijos = hijos;
		this.padre = padre;
	}

	public int altura() {
		return altura(this);
	}

	public int altura(NodoN<Directorio> n) {
		if(n==null) return -1;
		ArrayList<Integer> l=new ArrayList<Integer>();
		if (n.getHijos().isEmpty()){
			l.add(0);
		}else {
			for(int i=0;i<n.getHijos().size();i++){
				l.add(1+altura((NodoN<Directorio>) n.getHijos().get(i)));
			}
		}
		return Collections.max(l);
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
