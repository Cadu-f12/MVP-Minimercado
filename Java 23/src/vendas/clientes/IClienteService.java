package vendas.clientes;

public interface IClienteService {
    void cadastrarCliente(Cliente cliente);
    Cliente[] listarClientes();
}
