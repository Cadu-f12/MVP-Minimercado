import teste.Funcionalidades;
import vendas.clientes.Cliente;
import vendas.clientes.ClientePF;
import vendas.clientes.ClienteService;

public class Main {
    public static void main(String[] args){
        Funcionalidades func = new Funcionalidades();
        Cliente cliente = func.criarCliente();
        System.out.println((ClientePF) cliente);
    }
}
