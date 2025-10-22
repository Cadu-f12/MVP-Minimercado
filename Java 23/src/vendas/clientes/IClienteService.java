package vendas.clientes;

public interface IClienteService {

    //Consultar cliente
    Cliente consultarCliente(int id);

    //Listar clientes
    Cliente[] listarClientes();
    //Listar clientes que estão cadastrados na fidelidade
    Cliente[] listarClientesFidelidade();

    // Cadastrar clientes
    void cadastrarCliente(Cliente cliente);
}
