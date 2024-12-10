package main.java.br.edu.iftm.tspi.shopping_api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item {

    private String productIdentifier;
    private double price;
}
