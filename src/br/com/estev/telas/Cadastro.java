package br.com.estev.telas;
import br.com.estev.domain.Cliente;

import javax.swing.*;
import java.awt.event.*;

public class Cadastro extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField fieldNome;
    private JTextField fieldCPF;
    private JTextField fieldTelefone;
    private JTextField fieldEndereco;
    private JTextField fieldNumero;
    private JTextField fieldCidade;
    private JTextField fieldEstado;
    private JTextField fieldCEP;

    public Cadastro() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
                fieldNome.setText(""); fieldCPF.setText(""); fieldTelefone.setText(""); fieldEndereco.setText("");
                fieldNumero.setText(""); fieldCidade.setText(""); fieldEstado.setText(""); fieldCEP.setText("");
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private Cliente onOK() {
        try{
            Cliente cliente = new Cliente(fieldNome.getText(), fieldCPF.getText(), fieldTelefone.getText(),
                    fieldEndereco.getText(), fieldNumero.getText(), fieldCidade.getText(), fieldEstado.getText(),
                    fieldCEP.getText());
            JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!");
            return cliente;

        }
        catch(NumberFormatException exception){
            JOptionPane.showMessageDialog(null,"Algum valor invalido");
        }
        return null;
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    public Cliente inicia() {
        Cadastro dialog = new Cadastro();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
        return onOK();
    }

    public static void main(String[] args) {
        Cadastro dialog = new Cadastro();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }



}
