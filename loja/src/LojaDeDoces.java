import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LojaDeDoces extends JFrame {
    private JLabel[] lblDoces;
    private JTextField[] txtQuantidade;
    private double[] precos;
    private JButton btnOK;
    private JLabel lblTotal;
    private JButton btnFinalizar;

    public LojaDeDoces() {
        super("Loja de Doces");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializa os componentes
        lblDoces = new JLabel[3];
        lblDoces[0] = new JLabel("Doce 1 - R$5.00");
        lblDoces[1] = new JLabel("Doce 2 - R$3.50");
        lblDoces[2] = new JLabel("Doce 3 - R$2.00");

        txtQuantidade = new JTextField[3];
        for (int i = 0; i < txtQuantidade.length; i++) {
            txtQuantidade[i] = new JTextField(5);
        }

        precos = new double[]{5.00, 3.50, 2.00};

        btnOK = new JButton("OK");
        lblTotal = new JLabel("Total: R$0.00");
        btnFinalizar = new JButton("Finalizar Compra");

        // Adiciona os componentes ao painel
        JPanel panel = new JPanel(new GridLayout(5, 2));
        for (int i = 0; i < lblDoces.length; i++) {
            panel.add(lblDoces[i]);
            panel.add(txtQuantidade[i]);
        }
        panel.add(btnOK);
        panel.add(lblTotal);
        panel.add(btnFinalizar);

        // Adiciona o painel à janela
        add(panel);

        // Registra o listener para o botão OK
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularTotal();
            }
        });

        // Registra o listener para o botão Finalizar Compra
        btnFinalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalizarCompra();
            }
        });

        pack();
        setVisible(true);
    }

    private void calcularTotal() {
        double total = 0.0;
        for (int i = 0; i < txtQuantidade.length; i++) {
            int quantidade = Integer.parseInt(txtQuantidade[i].getText());
            total += quantidade * precos[i];
        }
        lblTotal.setText(String.format("Total: R$%.2f", total));
    }

    private void finalizarCompra() {
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja finalizar a compra?", "Finalizar Compra", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Compra finalizada. Obrigado!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LojaDeDoces();
            }
        });
    }
}
