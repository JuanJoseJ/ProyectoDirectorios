public class Principal {

    public static void main(String[] args) {
        Directorio d = new Directorio(1);
        Directorio d2 = new Directorio(2);
        Directorio d3 = new Directorio(3);
        Directorio d4 = new Directorio(4);
        d.setNombre("a");
        d2.setNombre("b");
        d3.setNombre("c");
        d4.setNombre("d");
        NodoN n=new NodoN(d);
        NodoN n1=new NodoN(d2);
        NodoN n2=new NodoN(d3);
        NodoN n3=new NodoN(d4);
        n.addHijo(n1);
        n.addHijo(n2);
        n1.addHijo(n3);
        System.out.println(d);
        ArbolN a=new ArbolN(n);
        System.out.println(a.getArbol());
        AVL a2= new AVL(a.ANtoAVL().getRaiz()); 
        a2.preordenR();

    }
}
