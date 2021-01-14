
/**
 * João Tanaca CB3002276
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.List;

public class Forms implements ActionListener {
    ConexaoBanco connection = new ConexaoBanco();
    List<Funcionario> funcao;
    int maximo = 0;
    int atual = 0;
    private JFrame jFrame = new JFrame();
    private JLabel labelNameSearch = new JLabel("Nome:");
    private JTextField textNameSearch = new JTextField(12);
    private JLabel labelName = new JLabel("Nome:");
    private JTextField textName = new JTextField(12);
    private JLabel labelSalario = new JLabel("Salário:");
    private JTextField textSalario = new JTextField(12);
    private JLabel labelCargo = new JLabel("Cargo:");
    private JTextField textCargo = new JTextField(12);
    private JButton buttonSearch = new JButton();
    private JButton buttonBefore = new JButton();
    private JButton buttonAfter = new JButton();
    private JPanel panel = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();

    Forms() {
        buttonSearch.setText("Pesquisar");
        buttonBefore.setText("Anterior");
        buttonAfter.setText("Próximo");
        buttonSearch.addActionListener(this);
        buttonBefore.addActionListener(this);
        buttonAfter.addActionListener(this);

        jFrame.setSize(300, 260);
        jFrame.setLocation(200, 200);
        jFrame.setTitle("TRABALHO PRATICO 04");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1.add(labelNameSearch);
        panel1.add(textNameSearch);

        panel2.add(labelName);
        panel2.add(textName);
        panel2.add(labelSalario);
        panel2.add(textSalario);
        panel2.add(labelCargo);
        panel2.add(textCargo);
        panel3.add(buttonBefore);
        panel3.add(buttonAfter);
        panel2.setLayout(new GridLayout(3, 2, 10, 10));
        panel.add(panel1);
        panel.add(buttonSearch);
        panel.add(panel2);
        panel.add(panel3);
        jFrame.add(panel);

        jFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if ("Pesquisar".equals(command)) {
            funcao = connection.select(textNameSearch.getText());
            maximo = funcao.size();
            atual = 0;
            textName.setText(funcao.get(atual).getNome());
            textSalario.setText(String.valueOf(funcao.get(atual).getSal()));
            textCargo.setText(funcao.get(atual).getCargo());
        }
        if ("Anterior".equals(command)) {
            if (atual > 0) {
                atual--;
                textName.setText(funcao.get(atual).getNome());
                textSalario.setText(String.valueOf(funcao.get(atual).getSal()));
                textCargo.setText(funcao.get(atual).getCargo());
            } else {
                JOptionPane.showMessageDialog(null, "está no minimo");
            }

        }
        if ("Próximo".equals(command)) {
            if (atual < maximo) {
                atual++;
                textName.setText(funcao.get(atual).getNome());
                textSalario.setText(String.valueOf(funcao.get(atual).getSal()));
                textCargo.setText(funcao.get(atual).getCargo());
            } else {
                JOptionPane.showMessageDialog(null, "está no maximo");
            }
        }

    }

    public static void main(String[] args) {
        Forms f = new Forms();
    }

}
