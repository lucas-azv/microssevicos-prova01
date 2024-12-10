package main.java.br.edu.iftm.tspi.shopping_api.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import main.java.br.edu.iftm.tspi.shopping_api.model.Shop;

@Repository
public interface ShopRepository extends MongoRepository<Shop, ObjectId> {
}
