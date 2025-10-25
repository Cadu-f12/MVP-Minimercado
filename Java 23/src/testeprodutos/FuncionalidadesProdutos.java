package testeprodutos;

import vendas.produtos.Produto;
import vendas.produtos.ProdutoService;
import java.util.Scanner;

public class FuncionalidadesProdutos {
    private static final ProdutoService produtoService = new ProdutoService(); // única instância compartilhada
    private final Scanner scanner = new Scanner(System.in);

    public void cadastrarProduto() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Código de Barras: ");
        String codigoBarras = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();

        System.out.print("Estoque inicial: ");
        int estoque = scanner.nextInt();

        Produto novo = new Produto(id, nome, codigoBarras, preco, estoque);
        produtoService.cadastroProduto(novo);

        System.out.println("Produto cadastrado com sucesso!");
    }

    public void listarProdutos() {
        System.out.println("=== Lista de Produtos ===");
        Produto[] produtos = produtoService.listarProdutos();
        if (produtos.length == 0) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto p : produtos) {
            System.out.println("ID: " + p.getId() +
                    " | Nome: " + p.getNome() +
                    " | Código: " + p.getCodigoBarras() +
                    " | Preço: " + p.getPrecos() +
                    " | Estoque: " + p.getEstoque());
        }
    }

    public void consultarProduto() {
        System.out.print("Digite o ID do produto: ");
        int id = scanner.nextInt();
        try {
            Produto p = produtoService.consultaProdutos(id);
            System.out.println("=== Produto Encontrado ===");
            System.out.println("ID: " + p.getId());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Código: " + p.getCodigoBarras());
            System.out.println("Preço: " + p.getPrecos());
            System.out.println("Estoque: " + p.getEstoque());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void editarProduto() {
        System.out.print("Digite o ID do produto a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo código de barras: ");
        String codigoBarras = scanner.nextLine();

        System.out.print("Novo preço: ");
        double preco = scanner.nextDouble();

        System.out.print("Novo estoque: ");
        int estoque = scanner.nextInt();

        Produto novo = new Produto(id, nome, codigoBarras, preco, estoque);
        produtoService.editarProdutos(id, novo);
        System.out.println("Produto atualizado com sucesso!");
    }

    public void registrarEstoque() {
        System.out.print("Digite o ID do produto: ");
        int id = scanner.nextInt();

        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tipo de registro (entrada / saida / baixa): ");
        String tipo = scanner.nextLine();

        try {
            produtoService.registroEstoque(id, quantidade, tipo);
            System.out.println("Registro de estoque realizado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
