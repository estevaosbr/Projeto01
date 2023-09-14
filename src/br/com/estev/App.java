package br.com.estev;

import br.com.estev.dao.ClienteMapDAO;
import br.com.estev.dao.IClienteDAO;
import br.com.estev.telas.*;

import javax.swing.*;

public class App {

    public static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();
        boolean online = true;

        while (online) {
            // TODO: 13/09/2023 CRIAR UMA CAIXA DE DIALOGOS PERSONALIZADA OU USAR OUTRO JFRAME NO LUGAR DE JOPTIONPANE
            // TODO: 13/09/2023 JOptionPane fecha ao usar dispose() em uma janela secundária
            JOptionPane jOptionPane = new JOptionPane();
            String opcao = JOptionPane.showInputDialog(null,
                    "1 - cadastro, 2 - consulta, 3 - exclusão, 4 - alteração, 5 - sair",
                    "Painel de clientes", JOptionPane.PLAIN_MESSAGE);

            while (!eOpcaoValida(opcao)) {
                opcao = JOptionPane.showInputDialog(null,
                        "1 - cadastro, 2 - consulta, 3 - exclusão, 4 - alteração, 5 - sair",
                        "Painel de clientes", JOptionPane.INFORMATION_MESSAGE);
            }

            while (eOpcaoValida(opcao)) {
                int opcaoInt = Integer.parseInt(opcao);

                if (opcaoInt == 5) {
                    break;
                } else if (opcaoInt == 1) {
                    Cadastro cadastro = new Cadastro();
                    try {
                        iClienteDAO.cadastrar(cadastro.inicia());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
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
            //exception.printStackTrace();
            return false;
        }
    }
}
