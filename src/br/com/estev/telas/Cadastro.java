package br.com.estev.telas;
import br.com.estev.dao.ClienteMapDAO;
import br.com.estev.dao.IClienteDAO;
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
    private final IClienteDAO iClienteDAO;

    public Cadastro() {
        setTitle("Cadastro");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        iClienteDAO = new ClienteMapDAO();

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

    private void onOK() {
        try{
            Cliente cliente = new Cliente(fieldNome.getText(), fieldCPF.getText(), fieldTelefone.getText(),
                    fieldEndereco.getText(), fieldNumero.getText(), fieldCidade.getText(), fieldEstado.getText(),
                    fieldCEP.getText());
            JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!");
            iClienteDAO.cadastrar(cliente);
        }
        catch(NumberFormatException exception){
            JOptionPane.showMessageDialog(null,"Algum valor invalido");
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public IClienteDAO iniciaCadastro(){
        pack();
        setVisible(true);
        return iClienteDAO;
    }

    public static void main(String[] args) {
        new Cadastro();
        System.exit(0);
    }
}
