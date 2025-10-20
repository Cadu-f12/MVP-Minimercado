package vendas.clientes;

import java.util.HashMap;
import java.util.Map;

public class ClienteService implements IClienteService {
    private final Map<Integer, Cliente> clientesCadastrados;

    public ClienteService() {
        this.clientesCadastrados = new HashMap<>();
    }

    /* Metodo que não retorna nada, porém inclui um cliente no "MAP clientesCadastrados"
    se o cliente não for repetido */
    public void cadastrarCliente(Cliente cliente) {
        if (this.clientesCadastrados.containsKey(cliente.getId())) {
            throw new ClienteDuplicadoException("ERRO: Este cliente já está cadastrado!");
        }
        clientesCadastrados.put(cliente.getId(), cliente);
    }

    /* Metodo que retorna apenas um cliente do "MAP clientesCadastrados"
    buscando pelo id do cliente */
    public Cliente consultarCliente(int id) {
        Cliente cliente = clientesCadastrados.get(id);
        return cliente;
    }

    /* Metodo que pega todos os clientes do "MAP clientesCadastrados"
    fazendo uma copia para o vetor Cliente[] e assim retornando ele */
    public Cliente[] listarClientes() {
        Cliente[] clientesListados = new Cliente[this.clientesCadastrados.size()];
        for (int i = 0; i < clientesCadastrados.size(); i++) {
            clientesCadastrados.values().toArray(clientesListados);
        }
        return clientesListados;
    }
}
