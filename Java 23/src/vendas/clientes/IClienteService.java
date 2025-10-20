package vendas.clientes;

public interface IClienteService {
    void cadastrarCliente(Cliente cliente);
    Cliente[] listarClientes();
    Cliente consultarCliente(int id);
    void cadastrarClienteFidelidadePF(ClientePF clienteCpf);
    void cadastrarClienteFidelidadePJ(ClientePJ clienteCnpj);
}
