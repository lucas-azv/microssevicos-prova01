package main.java.br.edu.iftm.tspi.shopping_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import main.java.br.edu.iftm.tspi.shopping_api.model.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}
