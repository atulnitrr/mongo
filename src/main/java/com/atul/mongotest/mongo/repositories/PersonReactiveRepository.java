package com.atul.mongotest.mongo.repositories;

import com.atul.mongotest.mongo.entity.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PersonReactiveRepository extends ReactiveMongoRepository<Person, String> {

    @Override
    Flux<Person> findAll();
    Flux<Person> findByFirstName(String firstName);
}
