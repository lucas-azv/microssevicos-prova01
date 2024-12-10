package br.edu.iftm.tspi.shopping_api.model.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import main.java.br.edu.iftm.tspi.shopping_api.model.Item;

@Data
public class ShoppingDTO {
    private String id;
    private String userIdentifier;
    private LocalDate date;
    private List<Item> items;
    private double total;
}
