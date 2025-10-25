import testeclientes.FuncionalidadesClientes;
import testeprodutos.FuncionalidadesProdutos;

public class Main {
    public static void main(String[] args) {
        FuncionalidadesClientes fCliente = new FuncionalidadesClientes();
        FuncionalidadesProdutos fProdutos = new FuncionalidadesProdutos();
        fCliente.cadastrarCliente();
        fProdutos.cadastrarProduto();

    }
}