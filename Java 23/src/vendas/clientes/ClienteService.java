package vendas.clientes;

import java.util.HashMap;
import java.util.Map;

public class ClienteService implements IClienteService {
    private final Map<Integer, Cliente> clientesCadastrados;

    public ClienteService(Map<Integer, Cliente> clientesCadastrados) {
        this.clientesCadastrados = new HashMap<>();
    }

    public void cadastrarCliente(Cliente cliente) {
        if (this.clientesCadastrados.containsKey(cliente.getId())) {
            throw new ClienteDuplicadoException("ERRO: Este cliente já está cadastrado!");
        }
        clientesCadastrados.put(cliente.getId(), cliente);
    }

    public Cliente[] listarClientes() {
        Cliente[] clientesListados = new Cliente[this.clientesCadastrados.size()];
        for (Cliente cliente : clientesListados) {
        }
        return new Cliente[0];
    }
}
