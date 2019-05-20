public class Principal {

    public static void main(String[] args) {
        Directorio d = new Directorio(1);
        Directorio d2 = new Directorio(2);
        Directorio d3 = new Directorio(3);
        Directorio d4 = new Directorio(4);
        Directorio d5 = new Directorio(5);
        Directorio d6 = new Directorio(6);
        Directorio d7 = new Directorio(7);
        Directorio d8 =new Directorio(8);
        d.setNombre("a");
        d2.setNombre("b");
        d3.setNombre("c");
        d4.setNombre("d");
        d5.setNombre("e");
        d6.setNombre("f");
        d7.setNombre("g");
        d8.setNombre("h");
        NodoN n=new NodoN(d);
        NodoN n1=new NodoN(d2);
        NodoN n2=new NodoN(d3);
        NodoN n3=new NodoN(d4);
        NodoN n4=new NodoN(d5);
        NodoN n5=new NodoN(d6);
        NodoN n6=new NodoN(d7);
        NodoN n7=new NodoN(d8);
        n.addHijo(n1);
        n.addHijo(n2);
        n.addHijo(n4);
        n1.addHijo(n3);
        n1.addHijo(n6);
        n4.addHijo(n5);
        n3.addHijo(n7);
        ArbolN a=new ArbolN(n);
        System.out.println(a.getArbol());
        AVL a2= new AVL(a.ANtoAVL().getRaiz()); 
        a2.preordenR();

    }
}
