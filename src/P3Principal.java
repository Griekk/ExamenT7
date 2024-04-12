import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P3Principal extends JFrame {
    private boolean turno;
    private JButton[][] botones;

    public P3Principal() {
        JPanel panelPrincipal = new JPanel(new GridLayout(3, 3));

        botones = new JButton[3][3];
        turno = true; //         true= turno x   ----   false = turno o

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton boton = new JButton("");
                boton.setPreferredSize(new Dimension(80, 80));
                int fila = i;
                int columna = j;
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (boton.getText().isEmpty()) {
                            if (turno) {
                                boton.setText("x");
                            } else {
                                boton.setText("o");
                            }
                            boton.setEnabled(false);
                            cambiarTurno();
                        }
                    }
                });
                botones[i][j] = boton;
                panelPrincipal.add(boton);
            }
        }

        add(panelPrincipal);
        setTitle("Tres en Raya");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void cambiarTurno() {
        turno = !turno;
    }
}