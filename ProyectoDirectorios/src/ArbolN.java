import java.util.ArrayList;

public class ArbolN<Directorio extends Comparable<Directorio>> {
    public NodoN<Directorio> raiz;

    public ArbolN(NodoN<Directorio> raiz) {
        this.raiz = raiz;
    }

    public ArbolN() {
    }

    public ArrayList<Directorio> getArbol() {
        ArrayList<Directorio> lista= new ArrayList<Directorio>();
        getArbol(raiz,lista);
        return lista;
    }

    private void getArbol(NodoN<Directorio> raiz, ArrayList<Directorio> lista) {
        if (raiz==null) {

        }else {
            lista.add(raiz.getLlave());
            for(int i=0;i<raiz.getHijos().size();i++){
                getArbol(raiz.findHijo(i),lista);
            }
        }
    }

    public AVL<Directorio> ANtoAVL(){ //Metodo para pasar de ArbolN a AVL
        ArrayList<Directorio> N=this.getArbol();
        NodoB nodo= new NodoB<Directorio>(N.get(0));
        AVL<Directorio> V=new AVL<Directorio>(nodo);
        for(int i=1;i<N.size();i++){
            try {
                V.insertar(new NodoB<Directorio>(N.get(i)));
            } catch (ExceptionNodo exceptionNodo) {
                System.out.println("Excepcion: "+exceptionNodo);
            }
        }
        return V;
    }


    public NodoN getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoN raiz) {
        this.raiz = raiz;
    }
}
