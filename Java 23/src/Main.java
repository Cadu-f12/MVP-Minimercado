import testeclientes.FuncionalidadesClientes;
import testeprodutos.FuncionalidadesProdutos;

public class Main {
    public static void main(String[] args) {
        FuncionalidadesClientes fClientes = new FuncionalidadesClientes();
        FuncionalidadesProdutos fProdutos = new FuncionalidadesProdutos();
        fProdutos.cadastrarProduto();
        fProdutos.listarProdutos();
    }
}