import vendas.ItensVenda;
import vendas.Venda;
import vendas.VendaService;
import vendas.clientes.*;

import java.time.LocalDateTime;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        ClienteService clienteService = new ClienteService();
        Cliente cliente1 = new ClientePF(12, "João", "6578", Categoria.NULO);
        Cliente cliente2 = new ClientePF(13, "Maria", "66778", Categoria.BRONZE);
        Cliente cliente3 = new ClientePF(14, "Carlos", "7566", Categoria.OURO);
        Cliente cliente4 = new ClientePF(15, "Fernando", "6238", Categoria.NULO);
        Cliente cliente1E = new ClientePF(12, "ZYON", "43234", Categoria.BRONZE);





        // TESTE DO DOMINIO CLIENTES

        // Cadastro de clientes
        clienteService.cadastrarCliente(cliente1);
        clienteService.cadastrarCliente(cliente2);
        clienteService.cadastrarCliente(cliente3);
        clienteService.cadastrarCliente(cliente4);

        // Consulta de um cliente
        cliente1 = clienteService.consultarCliente(12);
        System.out.println("-".repeat(25) + "Consuta de um cliente" + "-".repeat(25));
        System.out.println(cliente1);

        // Edição de um cliente
        clienteService.editarCliente(cliente1E);
        System.out.println("-".repeat(25) + "Edição de cliente"
                + "-".repeat(25));
        System.out.println(cliente1E);

        // Listagem de clientes
        Cliente[] clientes = clienteService.listarClientes();
        System.out.println("-".repeat(25) + "Listagem de clientes"
                + "-".repeat(25));
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}
