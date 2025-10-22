package vendas.clientes;

import vendas.clientes.excecoes.ClienteDuplicadoException;
import vendas.clientes.excecoes.ClienteNaoEncontradoException;

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
        if (!this.clientes.containsKey(id))
            throw new ClienteNaoEncontradoException("ERRO: Cliente não existe no sistema");
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

    /* Metodo que pega todos os clientes do "MAP clientes"
    fazendo uma cópia para o vetor Cliente[] e assim pegando somente os clientes que não são tem como
     NULO na categoria. */
    public Cliente[] listarClientesFidelidade() {
        Cliente[] clientes = new Cliente[this.clientes.size()];

        this.clientes.values().toArray(clientes);

        int qtdDeFieis = 0;
        for (Cliente cliente : clientes) {
            if (!(cliente.getCategoria() == Categoria.NULO)) {
                qtdDeFieis += 1;
            }
        }

        int i = 0;
        Cliente[] clientesFidelidade = new Cliente[qtdDeFieis];
        for (Cliente cliente : clientes) {
            if (!(cliente.getCategoria() == Categoria.NULO)) {
                clientesFidelidade[i] = cliente;
                i++;
            }
        }
        return clientesFidelidade;
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