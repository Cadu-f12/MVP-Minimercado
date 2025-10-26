package testeprodutos;

import vendas.produtos.Produto;
import vendas.produtos.ProdutoService;
import java.util.Scanner;

public class FuncionalidadesProdutos {
    private static final ProdutoService produtoService = new ProdutoService(); // única instância compartilhada
    private final Scanner scanner = new Scanner(System.in);

    public void cadastrarProduto() {
        System.out.print("ID: ");
        Produto produto = new Produto(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Nome: ");
        produto.setNome(scanner.nextLine());

        System.out.print("Código de Barras: ");
        produto.setCodigoBarras(scanner.nextLine());

        System.out.print("Preço: ");
        produto.setPreco(scanner.nextDouble());

        System.out.print("Estoque inicial: ");
        produto.setEstoque(scanner.nextInt());

        produtoService.cadastroProduto(produto);

        System.out.println("Produto cadastrado com sucesso!");
    }

    public void listarProdutos() {
        System.out.println("=== Lista de Produtos ===");
        Produto[] produtos = produtoService.listarProdutos();
        if (produtos.length == 0) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.printf("| %-3s | %-20s | %-20s | %-7s | %-7s |%n",
                "ID", "NOME", "CÓDIGO", "PREÇO", "ESTOQUE");
        System.out.println("-".repeat(73));
        for (Produto p : produtos) {
            System.out.printf("| %03d | %-20s | %-20s | %7.2f | %7d |%n",
                    p.getId(), p.getNome(), p.getCodigoBarras(), p.getPrecos(), p.getEstoque());
        }
    }

    public void consultarProduto() {

        Produto produto;
        while (true) {
            try {
                System.out.print("Digite o id que corresponde ao produto da consulta: ");
                produto = produtoService.consultaProdutos(scanner.nextInt());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\nTENTE NOVAMENTE!");
            }
        }
        System.out.println("== Produto encontrado ==");
        System.out.printf("| %-3s | %-20s | %-20s | %-7s | %-7s |%n",
                "ID", "NOME", "CÓDIGO", "PREÇO", "ESTOQUE");
        System.out.println("-".repeat(73));
        System.out.printf("| %03d | %-20s | %-20s | %7.2f | %7d |%n",
                produto.getId(), produto.getNome(), produto.getCodigoBarras(), produto.getPrecos(), produto.getEstoque());
    }

    public void editarProduto() {
        Produto produto;
        while (true) {
            try {
                System.out.print("Digite o ID do produto que deseja editar: ");
                produto = produtoService.consultaProdutos(scanner.nextInt());
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\nTENTE NOVAMENTE!");
            }
        }
        System.out.print("Novo nome: ");
        produto.setNome(scanner.nextLine());

        System.out.print("Novo código de barras: ");
        produto.setCodigoBarras(scanner.nextLine());

        System.out.print("Novo preço: ");
        produto.setPreco(scanner.nextDouble());

        System.out.print("Novo estoque: ");
        produto.setEstoque(scanner.nextInt());

        produtoService.editarProdutos(produto);
        System.out.println("Produto atualizado com sucesso!");
    }

    public void registrarEstoque() {
        System.out.print("Digite o ID do produto que deseja alterar o estoque: ");
        Produto produto = produtoService.consultaProdutos(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Digite a quantidade de saída ou entrada: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("""
                Tipo de registro 
                (entrada / saida / baixa)
                "Maiúsculo ou minúsculo é indiferente, apenas digite corretamente"
                Escolha:\s""");
        String tipo = scanner.nextLine();

        try {
            produtoService.registroEstoque(produto.getId(), quantidade, tipo.toLowerCase().trim());
            System.out.println("Registro de estoque realizado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}