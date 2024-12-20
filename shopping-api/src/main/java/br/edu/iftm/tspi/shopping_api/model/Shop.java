package main.java.br.edu.iftm.tspi.shopping_api.model;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;

import lombok.Data;

@Data
public class Shop {
    private ObjectId id;
    private String userIdentifier;
    private LocalDate date;
    private List<Item> items;
    private double total;
}
