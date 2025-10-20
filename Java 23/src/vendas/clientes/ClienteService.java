package vendas.clientes;

import java.util.HashMap;
import java.util.Map;

public class ClienteService implements IClienteService {
    private final Map<Integer, Cliente> clientes;
    private final Map<String, ClientePF> clientesFidelidadePF;
    private final Map<String, ClientePJ> clientesFidelidadePJ;

    public ClienteService() {
        this.clientes = new HashMap<>();
        this.clientesFidelidadePF = new HashMap<>();
        this.clientesFidelidadePJ = new HashMap<>();
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

    /* Metodo que retorna apenas um cliente do "MAP clientes"
    buscando pelo id do cliente */
    @Override
    public Cliente consultarCliente(int id) {
        Cliente cliente = clientes.get(id);
        return cliente;
    }

    /* Metodo que pega todos os clientes do "MAP clientes"
    fazendo uma copia para o vetor Cliente[] e assim retornando ele */
    @Override
    public Cliente[] listarClientes() {
        Cliente[] clientesListados = new Cliente[this.clientes.size()];
        for (int i = 0; i < clientes.size(); i++) {
            clientes.values().toArray(clientesListados);
        }
        return clientesListados;
    }

    @Override
    public void cadastrarClienteFidelidadePF(ClientePF clienteCpf) {
        if (this.clientesFidelidadePF.containsKey(clienteCpf.getCpf())) {
            throw new ClienteDuplicadoException("ERRO: Este cliente já está cadastrado!");
        }
        this.clientesFidelidadePF.put(clienteCpf.getCpf(), clienteCpf);
    }

    @Override
    public void cadastrarClienteFidelidadePJ(ClientePJ clienteCnpj) {

    }
}
