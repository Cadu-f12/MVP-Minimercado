import vendas.DescontoFidelidade;
import vendas.Venda;
import vendas.VendaService;
import vendas.carrinhocompras.CarrinhoDeCompras;
import vendas.carrinhocompras.ItensVenda;
import vendas.clientes.*;
import vendas.produtos.Produto;
import vendas.produtos.ProdutoService;

public class Main2 {
    private final static ClienteService clienteS = new ClienteService();
    private final static ProdutoService produtoS = new ProdutoService();
    private final static VendaService vendaS = new VendaService();
    private final static CarrinhoDeCompras carrinhoS = new CarrinhoDeCompras();

    public static void main(String[] args) {
        // --- Clientes ---

        /* Cadastro de clientes */

        Cliente cliente1 = new ClientePF(1);
        cliente1.setNome("Bianca");
        cliente1.setTelefone("48984008824");
        cliente1.setCategoria(Categoria.NULO);
        cliente1.setDocumento("473722134-82");

        Cliente cliente2 = new ClientePJ(2);
        cliente2.setNome("Amazon");
        cliente2.setTelefone("48991546024");
        cliente2.setCategoria(Categoria.PRATA);
        cliente2.setDocumento("231243245-87");

        clienteS.cadastrarCliente(cliente1);
        clienteS.cadastrarCliente(cliente2);

        /* Consultar cliente */

        System.out.println("Consulta:");
        Cliente cliente = clienteS.consultarCliente(1);
        System.out.println(cliente);

        /* Editar cliente */

        Cliente cliente3 = new ClientePF(1);
        cliente3.setNome("João");
        cliente3.setTelefone("56889434545");
        cliente3.setCategoria(Categoria.NULO);
        cliente3.setDocumento("123434567-90");

        clienteS.editarCliente(cliente3);

        /* Listar clientes */

        System.out.println("Lista de clientes:");
        Cliente[] clientes = clienteS.listarClientes();
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        // Cadastro de produtos

        /* Cadastro de produtos */
        Produto produto1 = new Produto(1);
        produto1.setNome("Banana");
        produto1.setCodigoBarras("4892334234");
        produto1.setPreco(4.5);
        produto1.setEstoque(50);

        Produto produto2 = new Produto(2);
        produto2.setNome("Coca-cola");
        produto2.setCodigoBarras("472835235");
        produto2.setPreco(5.5);
        produto2.setEstoque(35);

        produtoS.cadastroProduto(produto1);
        produtoS.cadastroProduto(produto2);

        /* Consulta de Produto */
        System.out.println("Consulta:");
        Produto produto = produtoS.consultaProdutos(2);
        System.out.println(produto);

        /* Editar produto */

        Produto produto3 = new Produto(2);
        produto3.setNome("Pureza");
        produto3.setCodigoBarras("472835235");
        produto3.setPreco(7.0);
        produto3.setEstoque(35);

        produtoS.editarProdutos(produto3);

        /* Alterar estoque */

        produtoS.registroEstoque(2, 10, "saida");

        /* Listar produtos */

        System.out.println("Listagem de produtos: ");
        Produto[] produtos = produtoS.listarProdutos();
        for (Produto productos : produtos) {
            System.out.println(productos);
        }

        // Registro de venda

        DescontoFidelidade desconto = new DescontoFidelidade(clienteS.consultarCliente(1));
        desconto.aplicarDesconto();

        ItensVenda item1 = new ItensVenda(produtoS.consultaProdutos(1));
        item1.setQuantidade(1);
        ItensVenda item2 = new ItensVenda(produtoS.consultaProdutos(2));
        item2.setQuantidade(1);

        carrinhoS.registrarItensVenda(item1);
        carrinhoS.registrarItensVenda(item2);

        Venda venda1 = new Venda(1, clienteS.consultarCliente(1), carrinhoS.listarItensVenda(),
                desconto.getDesconto(), carrinhoS.somarItensVenda());

        vendaS.registarVenda(venda1);

        System.out.println("Listagem de produtos após venda: ");
        produtos = produtoS.listarProdutos();
        for (Produto product: produtos) {
            System.out.println(product);
        }
    }
}
