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
        NodoN<Directorio> n=new NodoN<Directorio>(d);
        NodoN<Directorio> n1=new NodoN<Directorio>(d2);
        NodoN<Directorio> n2=new NodoN<Directorio>(d3);
        NodoN<Directorio> n3=new NodoN<Directorio>(d4);
        NodoN<Directorio> n4=new NodoN<Directorio>(d5);
        NodoN<Directorio> n5=new NodoN<Directorio>(d6);
        NodoN<Directorio> n6=new NodoN<Directorio>(d7);
        NodoN<Directorio> n7=new NodoN<Directorio>(d8);
        n.addHijo(n1);
        n.addHijo(n2);
        n.addHijo(n4);
        n1.addHijo(n3);
        n1.addHijo(n6);
        n4.addHijo(n5);
        n3.addHijo(n7);
        ArbolN<Directorio> a=new ArbolN<Directorio>(n);
        System.out.println(a.getArbol());
        AVL<Directorio> a2=a.ANtoAVL();
        a2.InOrden();
    }
}
