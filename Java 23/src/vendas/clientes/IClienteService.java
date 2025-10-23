package vendas.clientes;

public interface IClienteService {

    // Consultar um cliente para ser usado
    Cliente consultarCliente(int id);

    // Lista os clientes para ser usado
    Cliente[] listarClientes();

    // Cadastrar os clientes para ser usado no sistema
    void cadastrarCliente(Cliente cliente);

    // Editar um cliente já cadastrado no sistema
    void editarCliente(Cliente cliente);
}
