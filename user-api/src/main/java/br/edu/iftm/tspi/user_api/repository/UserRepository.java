package br.edu.iftm.tspi.user_api.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.tspi.user_api.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

}