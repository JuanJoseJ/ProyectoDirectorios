import java.util.*;

public class ArbolB <E extends Comparable<E>>{
    protected NodoB<E> raiz;

    public void preordenR() {
        preorden(raiz);
    }

    public void preorden(NodoB<E> raiz) {
        if (raiz==null) {

        }else {
            System.out.print(raiz.getLlave()+" ");
            preorden(raiz.getHijoIzq());
            preorden(raiz.getHijoDer());

        }
    }

    public ArrayList<E> preordenRLista() {
        ArrayList<E> lista= new ArrayList<E>();
        preordenLista(raiz,lista);
        return lista;
    }

    public void preordenLista(NodoB<E> raiz, ArrayList<E> lista) {
        if (raiz==null) {

        }else {
            lista.add(raiz.getLlave());
            preordenLista(raiz.getHijoIzq(),lista);
            preordenLista(raiz.getHijoDer(), lista);

        }
    }

    public void postordenR() {
        postorden(raiz);
    }

    public void postorden(NodoB<E> raiz) {
        if(raiz==null) {

        }else {

            postorden(raiz.getHijoIzq());
            postorden(raiz.getHijoDer());
            System.out.print(raiz.getLlave()+" ");
        }
    }

    public void inordenR() {
        inorden(raiz);
    }

    public void inorden(NodoB<E> raiz) {
        if(raiz==null) {

        }else {

            inorden(raiz.getHijoIzq());
            System.out.print(raiz.getLlave()+" ");
            inorden(raiz.getHijoDer());

        }
    }

    public ArbolB(NodoB<E> raiz) {
        super();
        this.raiz = raiz;
    }

    public ArbolB() {
        super();
        raiz=null;;
    }

    public NodoB<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoB<E> raiz) {
        this.raiz = raiz;
    }


}
