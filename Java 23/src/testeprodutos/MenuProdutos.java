package testeprodutos;

import testeclientes.FuncionalidadesClientes;

import java.util.Scanner;

public class MenuProdutos {
    private static final Scanner scanner = new Scanner(System.in);
    private static final FuncionalidadesProdutos fProdutos = new FuncionalidadesProdutos();

    public void ativarMenu() {
        while (true) {
            System.out.println("""
                        [1] - Cadastrar produto
                        [2] - Consultar produto
                        [3] - Editar produto
                        [4] - Listar produtos
                        [0] - Sair
                        Escolha:\s""");
            int escolha = Integer.parseInt(scanner.nextLine());
            switch (escolha) {
                case 1 -> {
                    fProdutos.cadastrarProduto();
                }
                case 2 -> {
                    fProdutos.consultarProduto();
                }
                case 3 -> {
                    fProdutos.editarProduto();
                }
                case 4 -> {
                    fProdutos.listarProdutos();
                }
                case 0 -> {
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    break;
                }
                default -> {
                    System.out.println("Opção inválida!");
                }
            }
            if (escolha == 0) {break;}
        }
    }
}
