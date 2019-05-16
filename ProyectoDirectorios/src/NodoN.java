import java.util.ArrayList;

public class NodoN<E extends Comparable<E>> {
	protected E llave;
	ArrayList hijos = new ArrayList<E>();
	protected NodoN<E> padre;
	
	public NodoN(E llave) {
		this.llave=llave;
		padre=null;
		hijos=null;
	}
}
