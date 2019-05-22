import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 * Creado por hadexexplade el 01 de febrero del 2016
 */
// public class PanelArbol<E extends Comparable<E>> extends JPanel
// {
//     private int width;
//     private int espacioVertical = 50;
//     private ArbolN<E> ArbolN;
//     private HashMap<NodoN<E>,Point> coordenadas;

//     public PanelArbol(ArbolN<E> ArbolN){
//         this.ArbolN = ArbolN;
//         this.coordenadas=new HashMap<NodoN<E>, Point>();
//     }

//     public void paintComponent(Graphics g){
//         super.paintComponent(g);
//         if(!ArbolN.estaVacia()){
//             dibujar(g,ArbolN.getRaiz(),getWidth()/2,30,getWidth()*5/(ArbolN.getArbol().size()*2));
//         }
//     }

//     private void dibujar(Graphics g, NodoN<E> raiz, int x, int y, int espacioH){
//         g.drawString(raiz.getLlave().toString(), x-2*raiz.getHijos().size(), y-2);
//         ArrayList<NodoN<E>>hijos=ArbolN.obtenerHijos(raiz);
//         coordenadas.put(raiz,new Point(x,y));
//         for(NodoN<E> hijo:hijos){
//             Point punto=coordenadas.get(ArbolN.obtenerPadre(hijo));
//             width=hijo.getLlave().toString().length()*20;
//             espacioH=espacioH+hijo.getLlave().toString().length();
//             dibujarLinea(g,x-espacioH,y+espacioVertical,punto.x,punto.y);
//             dibujar(g,hijo,x-espacioH,y+espacioVertical,espacioH/hijos.size());
//             x+=espacioH;
//         }
//     }

//     private void dibujarLinea(Graphics g, int x1, int y1, int x2, int y2){
//         g.drawLine(x1,y1-15,x2,y2);
//     }

// }
public class PanelArbol<E extends Comparable<E>> extends JPanel{
    private int radio=20;
    private int espacioVertical=70;
    private ArbolN<E> ArbolN;
    private HashMap<NodoN<E>,Point> coordenadas;

    public PanelArbol(ArbolN<E> ArbolN)
    {
        this.ArbolN = ArbolN;
        this.coordenadas=new HashMap<NodoN<E>, Point>();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(!ArbolN.estaVacia())
        {
            dibujar(g,ArbolN.getRaiz(),getWidth()/2,30,getWidth()/5);
        }
    }

    private void dibujar(Graphics g, NodoN<E> raiz, int x, int y, int espacioH)
    {
        g.drawOval(x-radio,y-radio,2*radio,2*radio);
        g.drawString(raiz.getLlave().toString() + "", x - 6, y + 4);
        ArrayList<NodoN<E>>hijos=ArbolN.obtenerHijos(raiz);
        coordenadas.put(raiz,new Point(x,y));
        for(NodoN<E> hijo:hijos)
        {
            Point punto=coordenadas.get(ArbolN.obtenerPadre(hijo));
            dibujarLinea(g,x-espacioH,y+espacioVertical,punto.x,punto.y);
            dibujar(g,hijo,x-espacioH,y+espacioVertical,espacioH/hijos.size());
            x+=espacioH;
        }
    }

    private void dibujarLinea(Graphics g, int x1, int y1, int x2, int y2)
    {
        double  d=Math.sqrt(espacioVertical*espacioVertical+(x2-x1)*(x2-x1));
        int xx1=(int)(x1-radio*(x1-x2)/d);
        int yy1=(int)(y1-radio*(y1-y2)/d);
        int xx2=(int)(x2+radio*(x1-x2)/d);
        int yy2=(int)(y2+radio*(y1-y2)/d);

        g.drawLine(xx1,yy1,xx2,yy2);

    }

}

