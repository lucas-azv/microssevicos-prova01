package br.edu.iftm.tspi.product_api.model;

public class ProductDTO {
    private String product_identifier;
    private String nome;
    private String descricao;
    private double preco;
    private String categoria_id;

    public ProductDTO() {
    }

    public ProductDTO(String product_identifier, String nome, String descricao, double preco, String categoria_id) {
        this.product_identifier = product_identifier;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria_id = categoria_id;
    }

    public String getProductIdentifier() {
        return product_identifier;
    }

    public void setProductIdentifier(String product_identifier) {
        this.product_identifier = product_identifier;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoriaId() {
        return categoria_id;
    }

    public void setCategoriaId(String categoria_id) {
        this.categoria_id = categoria_id;
    }
}
