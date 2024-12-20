package br.edu.iftm.tspi.product_api.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "product")
public class Product {

    @Id
    private ObjectId id;

    private String product_identifier;

    @Field("nome")
    private String nome;

    private String descricao;

    private double preco;

    @Field("categoria_id")
    private ObjectId categoria_id;

    public Product() {
    }

    public Product(ObjectId id, String product_identifier, String nome, String descricao, double preco, ObjectId categoria_id) {
        this.id = id;
        this.product_identifier = product_identifier;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria_id = categoria_id;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public ObjectId getCategoriaId() {
        return categoria_id;
    }

    public void setCategoriaId(ObjectId categoria_id) {
        this.categoria_id = categoria_id;
    }
}
