import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class NodoN<E extends Comparable<E>> {
	protected E llave;
	ArrayList<NodoN<E>> hijos=new ArrayList<NodoN<E>>();
	protected NodoN<E> padre;

	public NodoN(E llave) {
		this.llave = llave;
	}

	public NodoN(E llave, ArrayList hijos, NodoN<E> padre) {
		this.llave = llave;
		this.hijos = hijos;
		this.padre = padre;
	}


	//getts & setts (Ademas hice un metodo para agregar hijos a un nodo y para pedir un hijo en una
	//posicion del arreglo de hijos).

	public E getLlave() {
		return llave;
	}

	public void setLlave(E llave) {
		this.llave = llave;
	}

	public ArrayList getHijos() {
		return hijos;
	}

	public void addHijo(NodoN<E> hijo) {
		this.hijos.add(hijo);
	}

	public  NodoN findHijo(int posicion){
		return this.hijos.get(posicion);
	}

	public NodoN<E> getPadre() {
		return padre;
	}

	public void setPadre(NodoN<E> padre) {
		this.padre = padre;
	}
}
