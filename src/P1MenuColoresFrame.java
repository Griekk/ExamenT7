import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P1MenuColoresFrame {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Colores");

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        ventana.add(panel);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuColores = new JMenu("Colores");
        JMenuItem rojo = new JMenuItem("Rojo");
        JMenuItem verde = new JMenuItem("Verde");
        JMenuItem azul = new JMenuItem("Azul");
        JMenuItem salir = new JMenuItem("Salir");

        menuColores.add(rojo);
        menuColores.add(verde);
        menuColores.add(azul);
        menuColores.addSeparator();
        menuColores.add(salir);
        menuBar.add(menuColores);
        ventana.setJMenuBar(menuBar);

        rojo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.RED);
            }
        });

        verde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.GREEN);
            }
        });

        azul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.BLUE);
            }
        });

        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);
        ventana.setVisible(true);
    }
}
