package model;

import java.util.UUID;

public class Lancamento {
    private String id;
    private String data;       // formato: DD/MM/AAAA
    private String descricao;  // opcional
    private String categoria;
    private double valor;      // em XX,XX

    public Lancamento(String data, String descricao, String categoria, double valor) {
        this.id = UUID.randomUUID().toString();
        this.data = data;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
    }

    // Construtor vazio (necessário para Jackson/Gson)
    public Lancamento() {}

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    @Override
    public String toString() {
        return "Lancamento{" +
                "id='" + id + '\'' +
                ", data='" + data + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria='" + categoria + '\'' +
                ", valor=" + valor +
                '}';
    }
}
