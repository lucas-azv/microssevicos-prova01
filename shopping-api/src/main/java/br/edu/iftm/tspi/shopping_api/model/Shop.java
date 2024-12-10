package main.java.br.edu.iftm.tspi.shopping_api.model;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Shop {

    private ObjectId id;
    private String userIdentifier;
    private LocalDateTime date;
    private List<Item> items;
    private double total;
}
