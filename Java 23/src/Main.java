import vendas.clientes.*;

import java.util.Map;

public class Main {
    public static void main(String[] args){
        ClienteService clienteService = new ClienteService();
        Cliente cliente1 = new ClientePF(12, "João", "6578", Categoria.NULO);
        Cliente cliente2 = new ClientePF(13, "Maria", "66778", Categoria.BRONZE);
        Cliente cliente3 = new ClientePF(14, "Carlos", "7566", Categoria.GOLD);
        Cliente cliente4 = new ClientePF(15, "Fernando", "6238", Categoria.NULO);

        clienteService.cadastrarCliente(cliente1);
        clienteService.cadastrarCliente(cliente2);
        clienteService.cadastrarCliente(cliente3);
        clienteService.cadastrarCliente(cliente4);

        Cliente[] clientes = clienteService.listarClientes();
        Cliente[] clientesF = clienteService.listarClientesFidelidade();

        for (Cliente cliente : clientes) {
            System.out.println("(Cliente) " + cliente);
        }
        for (Cliente cliente : clientesF) {
            System.out.println("(Cliente fiél) " + cliente);
        }
    }
}
