import vendas.clientes.*;

import java.util.Map;

public class Main {
    public static void main(String[] args){

        // CÓDIGOS PARA TESTAR A CLASSE ClienteService:
        ClienteService clienteService = new ClienteService();

        ClientePF cliente1 = new ClientePF(2, "Carlos", "8989", Categoria.CLIENTE);
        ClientePF cliente2 = new ClientePF(4, "Bianca", "5645", Categoria.CLIENTE);
        ClientePJ cliente3 = new ClientePJ(65, "Pedro", "4235", Categoria.CLIENTE);

        clienteService.cadastrarCliente(cliente1);
        clienteService.cadastrarCliente(cliente2);
        clienteService.cadastrarCliente(cliente3);

        clienteService.cadastrarClienteFidelidadePF(cliente1);
        clienteService.cadastrarClienteFidelidadePJ(cliente3);

        Cliente[] clientes = clienteService.listarClientes();
        Cliente[] clientesFieis = clienteService.listarClientesFidelidade();

        System.out.println("LISTA DE CLIENTES: ");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
        System.out.println("LISTA DE CLIENTES FIDELIDADE: ");
        for (Cliente cliente : clientesFieis) {
            System.out.println(cliente);
        }
    }
}
