package br.com.estev.telas;

import br.com.estev.dao.IClienteDAO;
import br.com.estev.domain.Cliente;

import javax.swing.*;
import java.awt.event.*;


public class Consulta extends JDialog{
    private JPanel contentPanel;
    private JButton buscarButton;
    private JTextField textField1;
    private Cliente cliente;

    public Consulta(IClienteDAO iClienteDAO){
        setTitle("Busca de clientes");
        setContentPane(contentPanel);
        setModal(true);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        contentPanel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = textField1.getText();
                try{
                    cliente = iClienteDAO.buscar(Long.parseLong(cpf));
                    if (cliente != null){
                        JOptionPane.showMessageDialog(null, cliente.toString());
                        textField1.setText("");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"CLIENTE COM CPF " + textField1.getText() + " NÃO ENCONTRADO", "Não encontrado", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(null,"CPF INVÁLIDO, USE APENAS NÚMEROS", "ERRO",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        pack();
        setVisible(true);
    }
}
