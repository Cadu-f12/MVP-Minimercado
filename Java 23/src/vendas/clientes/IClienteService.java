package vendas.clientes;

public interface IClienteService {

    //Consultar cliente
    Cliente consultarCliente(int id);

    //Listar clientes
    Cliente[] listarClientes();

    // Cadastrar clientes
    void cadastrarCliente(Cliente cliente);

    // Editar o cliente
    void editarCliente(Cliente cliente);
}
