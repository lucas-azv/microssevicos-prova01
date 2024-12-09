package br.edu.iftm.tspi.product_api.model.dto;

import java.io.Serializable;

import br.edu.iftm.tspi.product_api.model.Product;

public class ProductDTO implements Serializable {
    private String id;
    private String nome;
    private String descricao;
    private double preco;
    private String categoriaId;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.id = product.getId().toString();
        this.nome = product.getNome();
        this.descricao = product.getDescricao();
        this.preco = product.getPreco();
        this.categoriaId = product.getCategoriaId() != null ? product.getCategoriaId().toString() : null;
    }

    // Getters e setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return categoriaId;
    }

    public void setCategoriaId(String categoriaId) {
        this.categoriaId = categoriaId;
    }
}
