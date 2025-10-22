package vendas.produtos;

import vendas.clientes.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ProdutoService implements IProdutoService{
    private Map<Integer, Cliente> clientes;

    public void ClienteService (){
        this.clientes = new HashMap<>();
    }
    public ProdutoService(Map<Integer, Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public void cadastroCliente(Cliente cliente) {

    }

    @Override
    public Cliente consultarCliente(int id) {
        return null;
    }

    @Override
    public Cliente[] listaCliente() {
        return new Cliente[0];
    }
}
