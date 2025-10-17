package vendas.produtos;

import vendas.clientes.Cliente;

public interface IProdutoService {
    void cadastroCliente(Cliente cliente);
    Cliente consultarCliente(int id);
    Cliente[] listaCliente();

}
