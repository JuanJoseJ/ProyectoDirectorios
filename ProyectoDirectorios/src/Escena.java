import java.awt.BorderLayout;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Escena extends JPanel {

    // public static void main(String[] args) {
    // Directorio d = new Directorio(1);
    // Directorio d2 = new Directorio(2);
    // Directorio d3 = new Directorio(3);
    // Directorio d4 = new Directorio(4);
    // Directorio d5 = new Directorio(5);
    // Directorio d6 = new Directorio(6);
    // Directorio d7 = new Directorio(7);
    // Directorio d8 =new Directorio(8);
    // d.setNombre("a");
    // d2.setNombre("b");
    // d3.setNombre("c");
    // d4.setNombre("d");
    // d5.setNombre("e");
    // d6.setNombre("f");
    // d7.setNombre("g");
    // d8.setNombre("h");
    // NodoN<Directorio> n=new NodoN<Directorio>(d);
    // NodoN<Directorio> n1=new NodoN<Directorio>(d2);
    // NodoN<Directorio> n2=new NodoN<Directorio>(d3);
    // NodoN<Directorio> n3=new NodoN<Directorio>(d4);
    // NodoN<Directorio> n4=new NodoN<Directorio>(d5);
    // NodoN<Directorio> n5=new NodoN<Directorio>(d6);
    // NodoN<Directorio> n6=new NodoN<Directorio>(d7);
    // NodoN<Directorio> n7=new NodoN<Directorio>(d8);
    // n.addHijo(n1);
    // n.addHijo(n2);
    // n.addHijo(n4);
    // n1.addHijo(n3);
    // n1.addHijo(n6);
    // n4.addHijo(n5);
    // n3.addHijo(n7);
    // ArbolN<Directorio> a=new ArbolN<Directorio>(n);
    // System.out.println(a.getArbol());
    // AVL<Directorio> a2=a.ANtoAVL();
    // a2.InOrden();
    // ArbolN<Directorio> a = crearArbol("B:\\Users\\santi\\Documents\\Prueba");
    // System.out.println(a.getArbol());
    // AVL<Directorio> avl = a.ANtoAVL();
    // avl.InOrden();
    // System.out.println(a.getArbol().size());
    // System.out.println(avl.InOrdenArrayList().size());
    // try {
    // System.out.println(avl.buscar(new Directorio("10", "",
    // 0)).getInfo().getRuta());
    // } catch (ExceptionNodo e) {
    // System.out.println(e.getMessage());
    // }
    // }

    private ArbolN<Directorio> a;
    private PanelArbol<Directorio> vista;

    public Escena() {
        a = crearArbol("/home/zettaploom/Documentos/P");
        // System.out.println(a.getArbol());
        AVL<Directorio> avl = a.ANtoAVL();
        // avl.InOrden();
        // System.out.println(a.getArbol().size());
        // System.out.println(avl.InOrdenArrayList().size());
        // try {
        // System.out.println(avl.buscar(new Directorio("10", "",
        // 0)).getInfo().getRuta());
        // } catch (ExceptionNodo e) {
        // System.out.println(e.getMessage());
        // }
        this.vista = new PanelArbol<Directorio>(a);
        this.setLayout(new BorderLayout());
        add(vista, BorderLayout.CENTER);
        JButton buscar = new JButton();
        buscar.setText("Abrir directorio");
        add(buscar, BorderLayout.SOUTH);
        buscar.addActionListener(e -> {
            // JOptionPane.showConfirmDialog(this, "¿Qué directorio quiere abrir?",
            // "Busqueda", optionType, messageType, icon)
            String busqueda = JOptionPane.showInputDialog("¿Qué directorio quiere abrir?",
                    a.getRaiz().llave.toString());
            try {
                String ruta = avl.buscar(new Directorio(busqueda, "", 0)).getInfo().getRuta();
                File f = new File(ruta);
                try {
                    Desktop.getDesktop().open(f);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "Advertencia", ERROR);
                }

            } catch (ExceptionNodo e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage(), "Advertencia", ERROR);
            }
        });
    }

   

    public static ArbolN<Directorio> crearArbol(String rutaRaiz) {
        File f = new File(rutaRaiz);
        ArbolN<Directorio> a = new ArbolN<Directorio>(new NodoN<Directorio>(new Directorio(f.getName(), f.getAbsolutePath(), f.length())));
        crearArbol(a.getRaiz());
        return a;
    }

    public static void crearArbol(NodoN<Directorio> nodo) {
        if (nodo != null) {
            File f = new File(nodo.getLlave().getRuta());
            if(f.isDirectory()&&f.listFiles()!=null){
                for (File dir : f.listFiles())
                    nodo.addHijo(new NodoN<Directorio>(new Directorio(dir.getName(), dir.getAbsolutePath(), dir.length())));            
                }
                for (NodoN<Directorio> nodoNuevo : nodo.getHijos()) 
                    crearArbol(nodoNuevo);
        }
    }
}
