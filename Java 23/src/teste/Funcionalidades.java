package teste;

import vendas.clientes.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Funcionalidades {

    // Criação de cliente com CPF ou CNPJ, para cadastrar no sistema
    public Cliente criarCliente(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Tipo de pessoa" +
                "\n1 - Pessoa Jurídica" +
                "\n2 - Pessoa física" +
                "\n-> ");
        int tipo = scanner.nextInt();

        System.out.print("Digite o seu id\n(obs: pode ser qualquer número)\n-> ");
        int id = scanner.nextInt();
        scanner.nextLine();

        switch (tipo) {
            case 1: // Caso o cliente for CNPJ
                ClientePJ clienteCNPJ = new ClientePJ(id);

                System.out.print("Digite o seu nome: ");
                clienteCNPJ.setNome(scanner.nextLine());

                System.out.print("Digite o seu telefone: ");
                clienteCNPJ.setTelefone(scanner.nextLine());

                System.out.print("Digite o seu CNPJ: ");
                clienteCNPJ.setCnpj(scanner.nextLine());

                clienteCNPJ.setCategoria(Categoria.NULO); //TODO CLIENTE NOVO CRIADO, POR PADRÃO É NÍVEL NULO DE FIDELIDADE

                System.out.println(clienteCNPJ);

                return clienteCNPJ;

            case 2: // Caso o cliente for CPF
                ClientePF clienteCPF = new ClientePF(id);

                System.out.print("Digite o seu nome: ");
                clienteCPF.setNome(scanner.nextLine());

                System.out.print("Digite o seu telefone: ");
                clienteCPF.setTelefone(scanner.nextLine());

                System.out.print("Digite o seu CPF: ");
                clienteCPF.setCpf(scanner.nextLine());

                clienteCPF.setCategoria(Categoria.NULO); //TODO CLIENTE NOVO CRIADO, POR PADRÃO É NÍVEL NULO DE FIDELIDADE

                return clienteCPF;
            default: // Caso a opção não existir
                System.out.println("OPÇÃO INVÁLIDA");
                return null;
        }
    }

    // Cadastrar um cliente na fidelidade (OBS: esse cliente deve já existir no sistema)
    public Cliente cadastrarFidelidade(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("-- // CADASTRO DE FIDELIDADE // --");

        System.out.print("Digite o nível da fidelidade" +
                "\nBronze" +
                "\nPrata" +
                "\nOuro" +
                "\n(Pode escrever maiúsculo ou minúsculo o importante é escrever certo)" +
                "\n-> ");
        String nivel = scanner.nextLine();
        switch (nivel.toLowerCase()) {
            case "bronze":
                cliente.setCategoria(Categoria.BRONZE);
                return cliente;
            case "prata":
                cliente.setCategoria(Categoria.PRATA);
                return cliente;
            case "ouro":
                cliente.setCategoria(Categoria.OURO);
                return cliente;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                return null;
        }
    }

}