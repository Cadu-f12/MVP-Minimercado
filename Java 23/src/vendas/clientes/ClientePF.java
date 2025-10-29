package vendas.clientes;

import vendas.clientes.excecoesclientes.AtributoIncompletoException;

import java.util.Objects;

public class ClientePF extends Cliente {
    private String cpf;

    public ClientePF(int id, String nome, String telefone, Categoria categoria, String cpf) {
        super(id, nome, telefone, categoria);
        this.cpf = cpf;
    }
    public ClientePF(int id) {
        super(id);
    }

    // Getter & setter para o CPF
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        if (Objects.equals(cpf, "")) {
            throw new AtributoIncompletoException("ERRO: O campo selecionado não pode ser estar vazio!");
        }
        this.cpf = cpf;
    }

    // Getter & Setter de CPF para a classe mãe
    @Override
    public String getDocumento() {
        return this.cpf;
    }
    @Override
    public void setDocumento(String cpfCnpj) {
        if (Objects.equals(cpfCnpj, "")) {
            throw new AtributoIncompletoException("ERRO: O campo selecionado não pode ser estar vazio!");
        }
        this.cpf = cpfCnpj;
    }

    @Override
    public String toString() {
        return "ClientePF{" +
                "cpf='" + cpf + '\'' +
                "} " + super.toString();
    }
}