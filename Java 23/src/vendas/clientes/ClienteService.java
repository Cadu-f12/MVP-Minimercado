package vendas.clientes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClienteService implements IClienteService {
    private final Map<Integer, Cliente> clientesCadastrados;

    public ClienteService() {
        this.clientesCadastrados = new HashMap<>();
    }

    public void cadastrarCliente(Cliente cliente) {
        if (this.clientesCadastrados.containsKey(cliente.getId())) {
            throw new ClienteDuplicadoException("Este cliente já está cadastrado!");
        }
        clientesCadastrados.put(cliente.getId(), cliente);
    }

    public Cliente[] listarClientes() {
        Cliente[] clientesListados = new Cliente[this.clientesCadastrados.size()];
        int i = 0;
        System.out.println(clientesCadastrados.get(i));
//        do {
//            clientesListados[i] = clientesCadastrados.get(i);
//            i++;
//        } while (clientesListados.length != clientesCadastrados.size());

        return new Cliente[0];
    }
}
