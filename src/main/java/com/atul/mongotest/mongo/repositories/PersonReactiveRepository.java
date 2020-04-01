package com.atul.mongotest.mongo.repositories;

import com.atul.mongotest.mongo.entity.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonReactiveRepository extends ReactiveMongoRepository<Person, String> {
}
