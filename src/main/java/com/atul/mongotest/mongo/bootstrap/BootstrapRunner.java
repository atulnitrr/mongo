package com.atul.mongotest.mongo.bootstrap;

import com.atul.mongotest.mongo.entity.Person;
import com.atul.mongotest.mongo.repositories.PersonReactiveRepository;
import com.atul.mongotest.mongo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class BootstrapRunner implements CommandLineRunner {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonReactiveRepository personReactiveRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("some dummy");
        System.out.println("started runner ");
        final Person person = new Person(UUID.randomUUID().toString(), "atul");
        final Person person1 = new Person(UUID.randomUUID().toString(), "people");
        final Person person2 = new Person(UUID.randomUUID().toString(), "drama");
        final List<Person> personList = Arrays.asList(person, person1, person2);
//        personRepository.saveAll(personList);

        final List<Person> savedPerson = personRepository.findAll();
        System.out.println(savedPerson);

        System.out.println("ended runner ");

        System.out.println( "count " + personReactiveRepository.count().block());
        final Flux<Person> personFlux =  personReactiveRepository.findByFirstName("atul");
        personFlux.subscribe(System.out::println);


    }
}
