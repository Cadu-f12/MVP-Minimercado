import teste.Funcionalidades;
import vendas.clientes.Cliente;
import vendas.clientes.ClientePF;

public class Main {
    public static void main(String[] args){
        Funcionalidades func = new Funcionalidades();
        Cliente cliente = func.criarCliente();
        System.out.println(cliente);
    }
}
