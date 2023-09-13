package br.com.estev;

import br.com.estev.dao.ClienteMapDAO;
import br.com.estev.dao.IClienteDAO;
import javax.swing.*;

public class App {

    public static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
                "1 - cadastro, 2 - consulta, 3 - exclusão, 4 - alteração, 5 - sair",
                "Painel de clientes",JOptionPane.PLAIN_MESSAGE);

        while (!eOpcaoValida(opcao)){
            if ("".equals(opcao)){
                break;
            }
            opcao = JOptionPane.showInputDialog(null,
                    "1 - cadastro, 2 - consulta, 3 - exclusão, 4 - alteração, 5 - sair",
                    "Painel de clientes",JOptionPane.INFORMATION_MESSAGE);
        }

        while (eOpcaoValida(opcao)){
            int opcaoInt = Integer.parseInt(opcao);

            if (opcaoInt == 5){
                break;
            } else if (opcaoInt == 1) {

                JScrollPane jTextField = new JScrollPane();
            }
        }
    }

    private static Boolean eOpcaoValida(String string){
        try{
            int opcao = Integer.parseInt(string);
            return opcao > 0 && opcao < 6;
        }
        catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(null,"Digite uma opção válida");
            exception.printStackTrace();
        }
        return false;
    }
}
