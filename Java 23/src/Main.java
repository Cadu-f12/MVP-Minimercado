
import vendas.clientes.Categoria;
import vendas.clientes.Cliente;
import vendas.clientes.ClienteService;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        ClienteService clienteService = new ClienteService();

        Cliente cliente3 = new Cliente(2, "Carlos", "7464", Categoria.CLIENTE);
        Cliente cliente5 = new Cliente(1, "Bianca", "6654", Categoria.CLIENTE);

        clienteService.cadastrarCliente(cliente3);
        clienteService.cadastrarCliente(cliente5);

        Cliente[] clientes = clienteService.listarClientes();

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}
