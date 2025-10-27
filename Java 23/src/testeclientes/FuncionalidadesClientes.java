package testeclientes;

import vendas.clientes.*;
import vendas.clientes.excecoes_clientes.ClienteNaoEncontradoException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncionalidadesClientes {
    private final Scanner scanner = new Scanner(System.in);
    private final ClienteService clienteService = new ClienteService();

    // Criação de cliente com CPF ou CNPJ, para cadastrar no sistema
    public void cadastrarCliente() {
        try {
            System.out.print("""
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
                System.out.println("""
                        OPÇÃO INVÁLIDA!
                        TENTE NOVAMENTE.""");
                return;
            }
            cliente.setCategoria(Categoria.NULO); // TODA CRIAÇÃO DE UM CLIENTE NOVO POR PADRÃO, SURGE COMO FIDELIDADE NULA.

            clienteService.cadastrarCliente(cliente);
            System.out.println("Cliente cadastrado com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("""
                Entrada inválida!
                Digite apenas números.""");
            scanner.nextLine();
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            scanner.nextLine();
            return;
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
            Digite o nível da fidelidade
            (BRONZE, PRATA, OURO)
            "Maiúsculo ou minúsculo é indiferente, apenas digite corretamente"
            Escolha:\s""");

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
        try {
            System.out.print("Digite o id que corresponde ao cliente da consulta: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            Cliente cliente = clienteService.consultarCliente(id);

            System.out.println("== Cliente encontrado ==");
            System.out.printf("| %-3s | %-20s | %-20s | %-10s | %-16s |%n",
                    "ID", "NOME", "TELEFONE", "FIDELIDADE", "CPF/CNPJ");
            System.out.println("-".repeat(85));

            System.out.printf("| %03d | %-20s | %-20s | %-10s | %-16s |%n",
                    cliente.getId(), cliente.getNome(), cliente.getTelefone(),
                    cliente.getCategoria(), cliente.getDocumento());
        } catch (InputMismatchException e) {
            System.out.println("""
                    Entrada inválida!
                    Digite apenas números.""");
            scanner.nextLine();
            return;
        } catch (ClienteNaoEncontradoException e) {
            System.out.println("""
            ID não encontrado!
            Certifique-se de que o cliente está cadastrado antes de consultar.""");
            scanner.nextLine();
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            scanner.nextLine();
            return;
        }
    }


    public void listarClientes() {
        Cliente[] clientes = clienteService.listarClientes();
        if (clientes.length == 0) {
            System.out.println("""
                    Nenhum cliente cadastrado!
                    Certifique-se de que os clientes estão cadastrados antes de consultar.""");
            return;
        }
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
        Cliente cliente;
        int id;
        try {
            System.out.print("Digite o ID do cliente que deseja editar: ");
            id = scanner.nextInt();
            scanner.nextLine();
            cliente = clienteService.consultarCliente(id);


            System.out.print("Novo nome: ");
            cliente.setNome(scanner.nextLine().trim());

            System.out.print("Novo telefone: ");
            cliente.setTelefone(scanner.nextLine().trim());

            System.out.print("""
                    Novo nível de fidelidade
                    (NULO, BRONZE, PRATA, OURO)
                    "Maiúsculo ou minúsculo é indiferente, apenas digite corretamente"
                    Escolha:\s""");
            cliente.setCategoria(Categoria.valueOf(scanner.nextLine().trim().toUpperCase()));

            System.out.print("Novo CNPJ/CPF: ");
            cliente.setDocumento(scanner.nextLine().trim());

            clienteService.editarCliente(cliente);
            System.out.println("Cliente atualizado com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("""
                    Entrada inválida!
                    Digite apenas números.""");
            scanner.nextLine();
            return;
        } catch (ClienteNaoEncontradoException e) {
            System.out.println("""
            ID não encontrado!
            Certifique-se de que o cliente está cadastrado antes de consultar.""");
            scanner.nextLine();
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("""
                    Categoria inválida!
                    Digite NULO, BRONZE, PRATA ou OURO.""");
            scanner.nextLine();
            return;
        } catch (Exception e) {
            System.out.println("Opção inválida!");
            scanner.nextLine();
            return;
        }
    }
}