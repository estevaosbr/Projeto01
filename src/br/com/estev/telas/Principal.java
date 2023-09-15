package br.com.estev.telas;

import br.com.estev.dao.IClienteDAO;

import javax.swing.*;
import java.awt.event.*;

public class Principal extends JDialog{
    private JPanel contentPane;
    private JButton cadastroButton;
    private JButton consultaButton;
    private JButton removerButton;
    private JButton alterarButton;
    private IClienteDAO iClienteDAO;


    public Principal() {
        setTitle("CRUD");
        setContentPane(contentPane);
        setModal(true);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Cadastro cadastro = new Cadastro();
                iClienteDAO = cadastro.iniciaCadastro();
                setVisible(true);
            }
        });

        consultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Consulta(iClienteDAO);
                setVisible(true);
            }
        });

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Principal();
    }
}
