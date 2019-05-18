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

    public NodoN getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoN raiz) {
        this.raiz = raiz;
    }
}
