package vendas.clientes;

public interface IClienteService {

    Cliente[] listarClientes();
    Cliente[] listarClientesFidelidade();

    Cliente consultarCliente(int id);

    // Cadastrar clientes
    void cadastrarCliente(Cliente cliente);
    // Quando já cadastrado, cadastrar cliente na fidelidade
    void cadastrarClienteFidelidadePF(ClientePF clienteCpf);
    void cadastrarClienteFidelidadePJ(ClientePJ clienteCnpj);
}
