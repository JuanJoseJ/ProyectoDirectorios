import java.util.ArrayList;

public class NodoN<E extends Comparable<E>> {
	protected E llave;
	ArrayList<NodoN<E>> hijos=new ArrayList<NodoN<E>>();
	protected NodoN<E> padre;

	public NodoN(E llave) {
		this.llave = llave;
	}

	public NodoN(E llave, ArrayList<NodoN<E>> hijos, NodoN<E> padre) {
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

	public ArrayList<NodoN<E>> getHijos() {
		return hijos;
	}

	public void addHijo(NodoN<E> hijo) {
		hijo.setPadre(this);
		this.hijos.add(hijo);
	}

	public  NodoN<E> findHijo(int posicion){
		return this.hijos.get(posicion);
	}

	public NodoN<E> getPadre() {
		return padre;
	}

	public void setPadre(NodoN<E> padre) {
		this.padre = padre;
	}
}
