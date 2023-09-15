package br.com.estev;

import br.com.estev.dao.ClienteMapDAO;
import br.com.estev.dao.IClienteDAO;

public class App {

    public static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();


    }

}
