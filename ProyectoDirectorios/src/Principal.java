public class Principal {

    public static void main(String[] args) {
        NodoN d=new NodoN();
        NodoN d1=new NodoN();
        NodoN d2=new NodoN();
        NodoN d3=new NodoN();
        d.addHijo(d1);
        d.addHijo(d2);
        d1.addHijo(d3);
        ArbolN a=new ArbolN(d);
        a.getArbol();
        System.out.println("La altura es de: "+a.getRaiz().altura());
    }
}
