import testeclientes.FuncionalidadesClientes;
import testeclientes.MenuClientes;
import testeprodutos.FuncionalidadesProdutos;
import testeprodutos.MenuProdutos;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MenuClientes menuClientes = new MenuClientes();
    private static final MenuProdutos menuProdutos = new MenuProdutos();

    public static void main(String[] args) {
        System.out.print("""
                [1] - Clientes
                [2] - Produtos
                [3] - Vendas
                Escolha o domínio que deseja testar:\s""");
        int escolha = Integer.parseInt(scanner.nextLine());

        switch (escolha) {
            case 1 -> {
                menuClientes.ativarMenu();
            }
            case 2 -> {
                menuProdutos.ativarMenu();
            }
            case 3 -> {
                System.out.println("""
                        [1] - Registar uma venda
                        [2] - Listar vendas
                        Escolha:\s""");
                escolha = Integer.parseInt(scanner.nextLine());
                switch (escolha) {
                    case 1:
                        //Método de meun
                }
            }
            default -> {
                System.out.println("Opção inválida!");
            }
        }
    }
}