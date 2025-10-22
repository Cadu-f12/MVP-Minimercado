package vendas.clientes;

public interface IClienteService {

    Cliente[] listarClientes();

    Cliente consultarCliente(int id);

    // Cadastrar clientes
    void cadastrarCliente(Cliente cliente);
}
