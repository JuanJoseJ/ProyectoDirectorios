import java.util.ArrayList;

public class ArbolN<E extends Comparable<E>> {
    public NodoN<E> raiz;

    public ArbolN(NodoN<E> raiz) {
        this.raiz = raiz;
    }

    public ArbolN() {
    }

    public ArrayList<E> getArbol() {
        ArrayList<E> lista= new ArrayList<E>();
        getArbol(raiz,lista);
        return lista;
    }

    private void getArbol(NodoN<E> raiz, ArrayList<E> lista) {
        if (raiz==null) {

        }else {
            lista.add(raiz.getLlave());
            for(int i=0;i<raiz.getHijos().size();i++){
                getArbol(raiz.findHijo(i),lista);
            }
        }
    }

    public AVL<E> ANtoAVL(){ //Metodo para pasar de ArbolN a AVL
        ArrayList<E> N=this.getArbol();
        NodoBinario<E> nodo= new NodoBinario<E>(N.get(0));
        AVL<E> V=new AVL<E>(nodo);
        for(int i=1;i<N.size();i++){
            try {
                V.insertar(new NodoBinario<E>(N.get(i)));
            } catch (ExceptionNodo exceptionNodo) {
                System.out.println("Excepcion: "+exceptionNodo);
            }
        }
        return V;
    }


    public NodoN<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoN<E> raiz) {
        this.raiz = raiz;
    }

	public boolean estaVacia() {
		return raiz==null;
	}

	public ArrayList<NodoN<E>> obtenerHijos(NodoN<E> elemento) {
        return elemento.getHijos();
    }

    public NodoN<E> obtenerPadre(NodoN<E> elemento){
        return elemento.getPadre();
    }
}
