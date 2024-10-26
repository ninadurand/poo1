package Eventos;

public class Local {
    private String nome;
    public Local(String nome) {
        this.nome = nome;
    }

    private String endereco;
    private int capacidadeMaxima;

    public Local(String nome, String endereco, int capacidadeMaxima) {
        this.nome = nome;
        this.endereco = endereco;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }
}
