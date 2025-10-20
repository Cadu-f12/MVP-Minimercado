import vendas.clientes.Categoria;
import vendas.clientes.Cliente;
import vendas.clientes.ClienteService;

import java.util.Map;

public class Main {
    public static void main(String[] args){

        // CÓDIGOS PARA TESTAR A CLASSE ClienteService:

        Cliente cliente1 = new Cliente(2, "Carlos", "8989", Categoria.CLIENTE);
        Cliente cliente2 = new Cliente(4, "Bianca", "5645", Categoria.CLIENTE);
        Cliente cliente3 = new Cliente(65, "Pedro", "4235", Categoria.CLIENTE);

        ClienteService clienteService = new ClienteService();

        clienteService.cadastrarCliente(cliente1);
        clienteService.cadastrarCliente(cliente2);
        clienteService.cadastrarCliente(cliente3);

        Cliente[] clientes = clienteService.listarClientes();

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}
