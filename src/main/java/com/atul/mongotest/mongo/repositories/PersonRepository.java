package com.atul.mongotest.mongo.repositories;

import com.atul.mongotest.mongo.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

}
