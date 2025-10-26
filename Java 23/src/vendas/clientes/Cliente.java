package vendas.clientes;

import vendas.clientes.excecoes_clientes.AtribudoIncompletoException;

import java.util.Objects;

public abstract class Cliente {
    private final int id;
    private String nome;
    private String telefone;
    private Categoria categoria;
    // Construtor da classe Cliente
    public Cliente(int id, String nome, String telefone, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.categoria = categoria;
    }
    public Cliente(int id) {
        this.id = id;
    }

    // Getter para ID
    public int getId() {
        return id;
    }

    // Getter & Setter para nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (Objects.equals(nome, "")) {
            throw new AtribudoIncompletoException("ERRO: O campo selecionado não pode ser estar vazio!");
        }
        this.nome = nome;
    }

    // Getter & Setter para telefone
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        if (Objects.equals(telefone, "")) {
            throw new AtribudoIncompletoException("ERRO: O campo selecionado não pode ser estar vazio!");
        }
        this.telefone = telefone;
    }

    // Getter & Setter para categoria
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        if (Objects.equals(categoria, null)) {
            throw new AtribudoIncompletoException("ERRO: O campo selecionado não pode ser estar vazio!");
        }
        this.categoria = categoria;
    }

    // Getter & Setter para o CPF/CNPJ das classes filhas
    public abstract String getDocumento();
    public abstract  void setDocumento(String cpfCnpj);

    // toString
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
