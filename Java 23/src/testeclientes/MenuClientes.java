package testeclientes;

import java.util.Scanner;

public class MenuClientes {
    private static final Scanner scanner = new Scanner(System.in);
    private static final FuncionalidadesClientes fClientes = new FuncionalidadesClientes();

    public void ativarMenu() {
        while (true) {
            System.out.print("""
                        [1] - Cadastrar cliente
                        [2] - Cadastrar cliente na fidelidade
                        [3] - Consultar cliente
                        [4] - Editar cliente
                        [5] - Listar clientes
                        [0] - Sair
                        Escolha:\s""");
            int escolha = Integer.parseInt(scanner.nextLine());
            switch (escolha) {
                case 1 -> {
                    fClientes.cadastrarCliente();
                }
                case 2 -> {
                    fClientes.cadastrarFidelidade();
                }
                case 3 -> {
                    fClientes.consultarCliente();
                }
                case 4 -> {
                    fClientes.editarCliente();
                }
                case 5 -> {
                    fClientes.listarClientes();
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
            if (escolha == 0) { break; }
        }
    }
}
