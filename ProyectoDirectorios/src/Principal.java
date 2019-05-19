public class Principal {

    public static void main(String[] args) {
        NodoN d=new NodoN(1);
        NodoN d1=new NodoN(2);
        NodoN d2=new NodoN(3);
        NodoN d3=new NodoN(4);
        d.addHijo(d1);
        d.addHijo(d2);
        d1.addHijo(d3);
        ArbolN a=new ArbolN(d);
        System.out.println(a.getArbol());
        AVL a2= new AVL(a.ANtoAVL().getRaiz()); 
        a2.preordenR();

    }
}
