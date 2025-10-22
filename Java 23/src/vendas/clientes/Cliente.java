package vendas.clientes;

public abstract class Cliente {
    private final int id;
    private String nome;
    private String telefone;
    private Categoria categoria;
    private boolean fidelidade;

    // Construtor da classe Cliente
    public Cliente(int id, String nome, String telefone, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.categoria = categoria;
    }

    // Getter para ID
    public int getId() {
        return id;
    }

    // Getter e Setter para nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para telefone
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Getter e Setter para categoria
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Getter e Setter para fidelidade
    public boolean getFidelidade() {
        return this.fidelidade;
    }
    public void setFidelidade(boolean fidelidade) {
        this.fidelidade = fidelidade;
    }

    // toString
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", categoria=" + categoria +
                ", fidelidade=" + fidelidade +
                '}';
    }
}
