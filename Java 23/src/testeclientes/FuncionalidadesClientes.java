package testeclientes;

import vendas.clientes.*;

import java.util.Scanner;

public class FuncionalidadesClientes {
    private final Scanner scanner = new Scanner(System.in);
    private final ClienteService clienteService = new ClienteService();

    // Criação de cliente com CPF ou CNPJ, para cadastrar no sistema
    public void cadastrarCliente() {
        while (true) { // repete até o usuário digitar uma opção válida
            System.out.print("""
                Tipo de pessoa
                1 - Pessoa Jurídica
                2 - Pessoa Física
                Digite uma opção:\s""");
            int tipo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Cliente cliente;

            if (tipo == 1) {
                cliente = new ClientePJ(id);

                System.out.print("Nome: ");
                cliente.setNome(scanner.nextLine());

                System.out.print("Telefone: ");
                cliente.setTelefone(scanner.nextLine());

                System.out.print("CNPJ: ");
                ((ClientePJ) cliente).setCnpj(scanner.nextLine());

            } else if (tipo == 2) {
                cliente = new ClientePF(id);

                System.out.print("Nome: ");
                cliente.setNome(scanner.nextLine());

                System.out.print("Telefone: ");
                cliente.setTelefone(scanner.nextLine());

                System.out.print("CPF: ");
                ((ClientePF) cliente).setCpf(scanner.nextLine());

            } else {
                System.out.println("OPÇÃO INVÁLIDA!\nTENTE NOVAMENTE.\n");
                continue; // volta para o início do while
            }
            cliente.setCategoria(Categoria.NULO); // TODA CRIAÇÃO DE UM CLIENTE NOVO POR PADRÃO, SURGE COMO FIDELIDADE NULA.

            try {
                clienteService.cadastrarCliente(cliente);
                System.out.println("\nCliente cadastrado com sucesso!\n");
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\nTENTE NOVAMENTE!");
                continue;
            }
            break; // sai do loop se tudo deu certo
        }
    }


    // Cadastrar um cliente na fidelidade (OBS: esse cliente deve já existir no sistema)
    public void cadastrarFidelidade() {
        Cliente cliente;

        // Loop para garantir que o cliente existe
        while (true) {
            try {
                System.out.print("Digite o id do cliente que deseja cadastrar na fidelidade: ");
                cliente = clienteService.consultarCliente(scanner.nextInt());
                scanner.nextLine(); // limpa o buffer
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\nTENTE NOVAMENTE!");
                scanner.nextLine(); // evita loop infinito se digitar texto
            }
        }

        // Escolha da fidelidade
        System.out.print("""
            Digite o nível da fidelidade:
            - Bronze
            - Prata
            - Ouro
            (Maiúsculo ou minúsculo é indiferente, apenas digite corretamente)
            Escolha: """);

        String nivel = scanner.nextLine().trim().toUpperCase(); // normaliza entrada

        try {
            Categoria categoria = Categoria.valueOf(nivel); // converte string para Enum
            cliente.setCategoria(categoria);
            clienteService.editarCliente(cliente);
            System.out.println("Fidelidade atualizada com sucesso para: " + categoria);
        } catch (IllegalArgumentException e) {
            System.out.println(""" 
                    OPÇÃO INVÁLIDA!
                    Edição não efetuada\s""");
        }
    }

    public void consultarCliente() {
        Cliente cliente;
        while (true) {
            try {
                System.out.print("Digite o id que corresponde ao cliente da consulta: ");
                cliente = clienteService.consultarCliente(scanner.nextInt());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\n TENTE NOVAMENTE!");
            }
        }
        System.out.println("== Cliente encontrado ==");
        System.out.printf("| %-3s | %-20s | %-20s | %-10s | %-16s |%n",
                "ID", "NOME", "TELEFONE", "FIDELIDADE", "CPF/CNPJ");
        System.out.println("-".repeat(85));

        System.out.printf("| %03d | %-20s | %-20s | %-10s | %-16s |%n",
                cliente.getId(), cliente.getNome(), cliente.getTelefone(),
                cliente.getCategoria(), cliente.getDocumento());
    }

    public void listarClientes() {
        Cliente[] clientes = clienteService.listarClientes();

        System.out.println("== Lista de clientes ==");
        System.out.printf("| %-3s | %-20s | %-20s | %-10s | %-16s |%n",
                "ID", "NOME", "TELEFONE", "FIDELIDADE", "CPF/CNPJ");
        System.out.println("-".repeat(85));
        for (Cliente cliente : clientes) {
            System.out.printf("| %03d | %-20s | %-20s | %-10s | %-16s |%n",
                    cliente.getId(), cliente.getNome(), cliente.getTelefone(),
                    cliente.getCategoria(), cliente.getDocumento());
        }
    }

    public void editarCliente() {
        Cliente cliente = null;

        while (true) {
            try {
                System.out.print("Digite o ID do cliente que deseja editar: ");
                int id = Integer.parseInt(scanner.nextLine());
                cliente = clienteService.consultarCliente(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("ID inválido. Digite apenas números.\n");
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\nTENTE NOVAMENTE!\n");
            }
        }

        System.out.print("Novo nome: ");
        cliente.setNome(scanner.nextLine().trim());

        System.out.print("Novo telefone: ");
        cliente.setTelefone(scanner.nextLine().trim());

        while (true) {
            try {
                System.out.print("Novo nível de fidelidade (BRONZE, PRATA, OURO): ");
                String nivel = scanner.nextLine().trim().toUpperCase();
                cliente.setCategoria(Categoria.valueOf(nivel));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Categoria inválida. Digite BRONZE, PRATA ou OURO.\n");
            }
        }

        System.out.print("Novo CNPJ/CPF: ");
        cliente.setDocumento(scanner.nextLine().trim());

        clienteService.editarCliente(cliente);
        System.out.println("\nCliente atualizado com sucesso!");
    }
}