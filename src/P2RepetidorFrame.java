import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P2RepetidorFrame extends JFrame {
    private int repeticiones;
    private JTextField salida;
    private JTextField entrada;
    private JButton menos;
    private JButton mas;

    public P2RepetidorFrame() throws HeadlessException {
        repeticiones = 2;
        setTitle("2 repeticiones");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel pnlBotones = new JPanel(new FlowLayout());
        menos = new JButton("-1");
        mas = new JButton("+1");
        menos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (repeticiones > 2) {
                    repeticiones--;
                    updateTitleAndButtons();
                    updateOutput();
                }
            }
        });
        mas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (repeticiones < 5) {
                    repeticiones++;
                    updateTitleAndButtons();
                    updateOutput();
                }
            }
        });
        pnlBotones.add(menos);
        pnlBotones.add(mas);
        add(pnlBotones, BorderLayout.PAGE_START);

        JPanel pnlCentral = new JPanel(new GridLayout(2, 2));
        pnlCentral.setBorder(new EmptyBorder(10, 10, 10, 10));
        pnlCentral.add(new JLabel("Entrada:", SwingConstants.RIGHT));
        entrada = new JTextField(20);
        salida = new JTextField(20);
        pnlCentral.add(entrada);
        pnlCentral.add(new JLabel("Salida:", SwingConstants.RIGHT));
        pnlCentral.add(salida);
        add(pnlCentral, BorderLayout.CENTER);

        entrada.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updateOutput();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updateOutput();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                updateOutput();
            }
        });

        setVisible(true);
    }

    private void updateTitleAndButtons() {
        setTitle(repeticiones + " repeticiones");
        menos.setEnabled(repeticiones > 2);
        mas.setEnabled(repeticiones < 5);
    }

    private void updateOutput() {
        String entrada = this.entrada.getText();
        StringBuilder salida = new StringBuilder();
        for (int i = 0; i < entrada.length(); i++) {
            char c = entrada.charAt(i);
            for (int j = 0; j < repeticiones; j++) {
                salida.append(c);
            }
        }
        this.salida.setText(salida.toString());
    }

    public static void main(String[] args) {
        new P2RepetidorFrame();
    }
}