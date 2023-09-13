package br.com.estev.dao;

import br.com.estev.domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO implements IClienteDAO{

    private Map<Long, Cliente> map;

    public ClienteMapDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (this.map.containsKey(cliente.getCpf())){
            return false;
        }
        map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = this.map.get(cpf);

        if (clienteCadastrado != null){
            this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente cliente1 = this.map.get(cliente.getCpf());
        if (cliente1 != null){
            cliente1.setNome(cliente.getNome());
            cliente1.setCpf(cliente.getCpf());
            cliente1.setEndereco(cliente.getEndereco());
            cliente1.setCep(cliente.getCep());
            cliente1.setTelefone(cliente.getTelefone());
            cliente1.setCidade(cliente.getCidade());
            cliente1.setEstado(cliente.getEstado());
        }
    }

    @Override
    public Cliente buscar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
}
