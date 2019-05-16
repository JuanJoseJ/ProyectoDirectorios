import Arboles.NodoB;

public class NodoN<E extends Comparable<E>> {
	protected E llave;
	ArrayList Hijos = new ArrayList<E>;
	protected NodoN<E> padre;
	
	public NodoN(E llave) {
		this.llave=llave;
		padre=null;		
	}
}
