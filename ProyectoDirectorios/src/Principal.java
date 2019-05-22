import javax.swing.JFrame;

public class Principal {

    public static void main(String[] args){
        JFrame jf=new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(1200,600);
        jf.add(new Escena());
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}