import java.util.ArrayList;

public class ArbolBinarioBusqueda <E extends Comparable<E>> extends ArbolB<E> {
    public ArbolBinarioBusqueda(NodoB<E> raiz) {
        super(raiz);
    }

    public NodoB<E> buscarAntecesor(NodoB<E> nodo) throws ExceptionNodo{
        if(nodo.getHijoIzq()==null)
            throw new ExceptionNodo("Error, el nodo no tiene hijo de la izquierda");
        return buscarMaximo(nodo.getHijoIzq());
    }

    public NodoB<E> buscarMaximo(NodoB<E> nodo) throws ExceptionNodo{
        if(nodo.getHijoDer()==null)
            return nodo;
        else
            return buscarMaximo(nodo.getHijoDer());
    }

    public NodoB<E> buscarPredecesor(NodoB<E> nodo) throws ExceptionNodo{
        if(nodo.getHijoDer()==null)
            throw new ExceptionNodo("Error, el nodo no tiene hijo de la derecha");
        return buscarMinimo(nodo.getHijoDer());
    }

    public NodoB<E> buscarMinimo(NodoB<E> nodo) throws ExceptionNodo{
        if(nodo.getHijoIzq()==null)
            return nodo;
        else
            return buscarMinimo(nodo.getHijoIzq());
    }

    public NodoB<E> buscar(E info, NodoB<E> nodo) throws ExceptionNodo{
        if(nodo==null)
            throw new ExceptionNodo("El nodo no existe");
        if(info.compareTo(nodo.getLlave())<0)
            return buscar(info,nodo.getHijoIzq());
        if(info.compareTo(nodo.getLlave())>0)
            return buscar(info,nodo.getHijoDer());
        return nodo;
    }

    public NodoB<E> buscar(E info) throws ExceptionNodo{
        return buscar(info, this.raiz);
    }

    public void insertar(NodoB<E> nodo) throws ExceptionNodo {
        raiz=insertar(nodo,raiz);
    }

    protected NodoB<E> insertar(NodoB<E> nodo, NodoB<E> raiz) throws ExceptionNodo{
        if(raiz==null)
            raiz=nodo;
        else {
            if(nodo.getLlave().compareTo(raiz.getLlave())<0)
                raiz.setHijoIzq(insertar(nodo,raiz.getHijoIzq()));
            if(nodo.getLlave().compareTo(raiz.getLlave())>0)
                raiz.setHijoDer(insertar(nodo,raiz.getHijoDer()));
            if(nodo.getLlave().compareTo(raiz.getLlave())==0)
                throw new ExceptionNodo("El nodo está repetido");
        }
        return raiz;
    }

    public void eliminar(E info) throws ExceptionNodo {
        eliminar(info,raiz);
    }

    protected NodoB<E> eliminar(E info,NodoB<E> raiz) throws ExceptionNodo {
        if(raiz==null)
            throw new ExceptionNodo("El nodo no existe");
        else {
            if(info.compareTo(raiz.getLlave())<0)
                raiz.setHijoIzq(eliminar(info,raiz.getHijoIzq()));
            else
            if(info.compareTo(raiz.getLlave())>0)
                raiz.setHijoDer(eliminar(info,raiz.getHijoDer()));
            else {
                if(raiz.getHijoDer()!=null&&raiz.getHijoIzq()!=null) {
                    NodoB<E> antecesor=buscarAntecesor(raiz);
                    raiz.setLlave(antecesor.getLlave());
                    raiz.setHijoIzq(eliminar(antecesor.getLlave(),raiz.getHijoIzq()));
                }else
                if(raiz.getHijoDer()!=null) {
                    raiz=raiz.getHijoDer();
                }else
                    raiz=raiz.getHijoIzq();
            }
        }
        return raiz;
    }


}

@SuppressWarnings("serial")
class ExceptionNodo extends Exception{
    public ExceptionNodo(String s) {
        super(s);
    }
}