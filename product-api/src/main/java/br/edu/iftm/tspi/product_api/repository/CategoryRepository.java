package br.edu.iftm.tspi.product_api.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.edu.iftm.tspi.product_api.model.Category;

public interface CategoryRepository extends MongoRepository<Category, ObjectId> {
}