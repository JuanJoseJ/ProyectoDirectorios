public class NodoB<E extends Comparable<E>> {
    protected E llave;
    protected NodoB<E> HijoIzq;
    protected NodoB<E> HijoDer;
    protected NodoB<E> padre;

    public NodoB(E llave) {
        super();
        this.llave = llave;
        HijoDer = null;
        padre=null;
        HijoIzq=null;
    }

    public NodoB(E llave, NodoB<E> HijoIzq, NodoB<E> HijoDer, NodoB<E> padre) {
        super();
        this.llave = llave;
        this.HijoIzq = HijoIzq;
        this.HijoDer = HijoDer;
        this.padre = padre;
    }

    public int altura() {
        return alturaR(this);
    }

    public int alturaR(NodoB<E> n) {
        if(n==null) return -1;

        int altder=(n.getHijoDer()==null? 0:1 +alturaR(n.getHijoDer()));
        int altizq=(n.getHijoIzq()==null? 0:1 +alturaR(n.getHijoIzq()));
        return Math.max(altder, altizq);

    }

    public int FE() {
        return alturaR(this.getHijoDer()) - alturaR(this.getHijoIzq());
    }


    public E getLlave() {
        return llave;
    }


    public void setLlave(E llave) {
        this.llave = llave;
    }

    public NodoB<E> getHijoIzq() {
        return HijoIzq;
    }



    public void setHijoIzq(NodoB<E> HijoIzq) {
        if(HijoIzq!=null) {
            HijoIzq.setPadre(this);
        }
        this.HijoIzq = HijoIzq;
    }

    public NodoB<E> getHijoDer() {
        return HijoDer;
    }

    public void setHijoDer(NodoB<E> HijoDer) {
        if(HijoDer!=null) {
            HijoDer.setPadre(this);
        }
        this.HijoDer = HijoDer;
    }

    public NodoB<E> getPadre() {
        return padre;
    }

    public void setPadre(NodoB<E> padre) {
        this.padre = padre;
    }


}

