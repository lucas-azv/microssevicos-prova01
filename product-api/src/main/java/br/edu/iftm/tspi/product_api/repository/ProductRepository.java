package br.edu.iftm.tspi.product_api.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.tspi.product_api.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {
    List<Product> findByCategoriaId(ObjectId categoryId);

    Optional<Product> findByProductIdentifier(String productIdentifier);
}
