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

    @Override
    public Cliente[] listarClientesFidelidade(){
        Cliente[] listaClientes = new Cliente[this.clientes.size()];

        clientes.values().toArray(listaClientes);

        int qtdClienteFieis = 0;
        for (Cliente cliente : listaClientes) {
            if (cliente.getFidelidade()) {
                qtdClienteFieis += 1;
            }
        }

        int i = 0;
        Cliente[] listaClientesFieis = new Cliente[qtdClienteFieis];
        for (Cliente cliente : listaClientes) {
            if (cliente.getFidelidade()) {
               listaClientesFieis[i] = cliente;
               i++;
            }
        }
        return listaClientesFieis;
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


    /* Metodo que não retorna nada, porém inclui um cliente no "MAP clientesFidelidadePF" e marca como verdadeiro a fidelidade
    se o cliente não for repetido */
    @Override
    public void cadastrarClienteFidelidadePF(ClientePF clienteCpf) {
        if (this.clientesFidelidadePF.containsKey(clienteCpf.getCpf())) {
            throw new ClienteDuplicadoException("ERRO: Este cliente já está cadastrado!");
        }
        clienteCpf.setFidelidade(true);
        this.clientesFidelidadePF.put(clienteCpf.getCpf(), clienteCpf);
    }

    /* Metodo que não retorna nada, porém inclui um cliente no "MAP clientesFidelidadePJ" e marca como verdadeiro a fidelidade
    se o cliente não for repetido */
    @Override
    public void cadastrarClienteFidelidadePJ(ClientePJ clienteCnpj) {
        if (this.clientesFidelidadePJ.containsKey(clienteCnpj.getCnpj())) {
            throw new ClienteDuplicadoException("ERRO: Este cliente já está cadastrado!");
        }
        clienteCnpj.setFidelidade(true);
        this.clientesFidelidadePJ.put(clienteCnpj.getCnpj(), clienteCnpj);
    }
}
