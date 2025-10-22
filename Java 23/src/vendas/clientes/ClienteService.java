package vendas.clientes;

import java.util.HashMap;
import java.util.Map;

public class ClienteService implements IClienteService {
    private final Map<Integer, Cliente> clientes;


    public ClienteService() {
        this.clientes = new HashMap<>();
    }

    /* Metodo que retorna apenas um cliente do "MAP clientes"
    buscando pelo id do cliente */
    @Override
    public Cliente consultarCliente(int id) {
        return this.clientes.get(id);
    }

    /* Metodo que pega todos os clientes do "MAP clientes"
    fazendo uma cópia para o vetor Cliente[] e assim retornando ele */
    @Override
    public Cliente[] listarClientes() {
        Cliente[] clientesListados = new Cliente[this.clientes.size()];

        clientes.values().toArray(clientesListados);

        return clientesListados;
    }

    /* Metodo que não retorna nada, porém inclui um cliente no "MAP clientes"
    se o cliente não for repetido */
    @Override
    public void cadastrarCliente(Cliente cliente) {
        if (this.clientes.containsKey(cliente.getId())) {
            throw new ClienteDuplicadoException("ERRO: Este cliente já está cadastrado!");
        }
        clientes.put(cliente.getId(), cliente);
    }
}
