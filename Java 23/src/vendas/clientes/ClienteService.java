package vendas.clientes;

import vendas.clientes.excecoes_clientes.ClienteDuplicadoException;
import vendas.clientes.excecoes_clientes.ClienteNaoEncontradoException;

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
        // Lança uma exceção quando o cliente não é encontrado!
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

    /* Metodo que não retorna nada, porém inclui um cliente no "MAP clientes"
    se o cliente não for repetido */
    @Override
    public void cadastrarCliente(Cliente cliente) {
        if (this.clientes.containsKey(cliente.getId())) {
            throw new ClienteDuplicadoException("ERRO: Este cliente já está cadastrado!");
        }
        clientes.put(cliente.getId(), cliente);
    }

    /*Metodo que não retorna nada, ele recebe o novo cliente (OBS: O novo cliente deve contar o mesmo ID que o que será editado)
    Após isso o cliente "antigo" será substituido pelo novo cliente */
    @Override
    public void editarCliente(Cliente novoCliente) {
        if (!this.clientes.containsKey(novoCliente.getId())) {
            throw new ClienteNaoEncontradoException("ERRO: Cliente não existe no sistema");
        }
        clientes.put(novoCliente.getId(), novoCliente);
    }
}