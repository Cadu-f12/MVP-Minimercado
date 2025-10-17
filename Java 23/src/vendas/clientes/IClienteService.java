package vendas.clientes;

import java.util.ArrayList;

public interface IClienteService {
    void cadastrarCliente(Cliente cliente);
    Cliente[] listarClientes();
}
