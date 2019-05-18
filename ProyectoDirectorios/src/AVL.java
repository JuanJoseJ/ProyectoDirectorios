public class AVL<E extends Comparable<E>> extends ArbolBinarioBusqueda<E> {

    public AVL(NodoB<E> raiz) {
        super(raiz);
    }

    @Override
    public void insertar(NodoB<E> nodo) throws ExceptionNodo {
        super.insertar(nodo);
        balancear(nodo);
    }

    @Override
    public void eliminar(E info) throws ExceptionNodo {
        NodoB<E> n=buscar(info);
        NodoB<E> padre;
        if(n.getHijoDer()!=null&&n.getHijoIzq()!=null)
            padre=buscarAntecesor(n).getPadre();
        else
            padre=n.getPadre();
        super.eliminar(info);
        if(padre==null)
            balancear(raiz);
        else
            while(padre!=null) {
                balancear(padre);
                padre=padre.getPadre();
            }
    }

    private void balancear(NodoB<E> nodo) {
        NodoB<E> desb=desbalance(nodo);
        if(desb!=null) {
            NodoB<E> p=desb.getPadre();
            if(desb.FE()>0) {
                if(desb.getHijoDer().FE()>=0)
                    desb=balanceSimpleIzq(desb);
                else
                    desb=balanceDobleIzq(desb);
            } else
            if(desb.FE()<0) {
                if(desb.getHijoIzq().FE()<=0)
                    desb=balanceSimpleDer(desb);
                else
                    desb=balanceDobleDer(desb);
            }
            if(p==null)
                raiz=desb;
            else
            if(desb.getLlave().compareTo(p.getLlave())>0)
                p.setHijoDer(desb);
            else
                p.setHijoIzq(desb);
        }
    }



    private NodoB<E> balanceSimpleIzq(NodoB<E> nodo){
        NodoB<E> der=nodo.getHijoDer();
        der.setPadre(nodo.getPadre());
        nodo.setHijoDer(der.getHijoIzq());
        der.setHijoIzq(nodo);
        return der;
    }

    private NodoB<E> balanceSimpleDer(NodoB<E> nodo){
        NodoB<E> izq=nodo.getHijoIzq();
        izq.setPadre(nodo.getPadre());
        nodo.setHijoIzq(izq.getHijoDer());
        izq.setHijoIzq(nodo);
        return izq;
    }

    private NodoB<E> balanceDobleDer(NodoB<E> nodo){
        nodo.setHijoIzq(balanceSimpleIzq(nodo.getHijoIzq()));
        return balanceSimpleDer(nodo);
    }

    private NodoB<E> balanceDobleIzq(NodoB<E> nodo){
        nodo.setHijoIzq(balanceSimpleDer(nodo.getHijoDer()));
        return balanceSimpleIzq(nodo);
    }

    private NodoB<E> desbalance(NodoB<E> nodo){
        NodoB<E> nodoAux=nodo;
        while(nodoAux!=null&&Math.abs(nodoAux.FE())<=1)
            nodoAux=nodoAux.getPadre();
        return nodoAux;
    }

}