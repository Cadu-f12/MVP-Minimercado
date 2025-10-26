package vendas.clientes;

import vendas.clientes.excecoes_clientes.AtributoIncompletoException;

import java.util.Objects;

public class ClientePJ extends Cliente {
    private String cnpj;

    public ClientePJ(int id, String nome, String telefone, Categoria categoria, String cnpj) {
        super(id, nome, telefone, categoria);
        this.cnpj = cnpj;
    }
    public ClientePJ(int id) {
        super(id);
    }

    // Getter & setter para CNPJ
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        if (Objects.equals(cnpj, "")) {
            throw new AtributoIncompletoException("ERRO: O campo selecionado não pode ser estar vazio!");
        }
        this.cnpj = cnpj;
    }

    // Getter & Setter de CNPJ para a classe mãe
    @Override
    public String getDocumento() {
        return this.cnpj;
    }
    @Override
    public void setDocumento(String cpfCnpj) {
        if (Objects.equals(cpfCnpj, "")) {
            throw new AtributoIncompletoException("ERRO: O campo selecionado não pode ser estar vazio!");
        }
        this.cnpj = cpfCnpj;
    }

    @Override
    public String toString() {
        return "ClientePJ{" +
                "cnpj='" + cnpj + '\'' +
                "} " + super.toString();
    }
}