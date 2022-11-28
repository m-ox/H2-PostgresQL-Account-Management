package com.amida.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

  private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(AccessingDataJpaApplication.class);
  }

  @Bean
  public CommandLineRunner demo(CustomerRepository repository) {
    return (args) -> {
      // save a few customers
      repository.save(new Customer("Maud", "Ox"));
      repository.save(new Customer("Tim", "Jackreece"));
      repository.save(new Customer("Abena", "Abenason"));
      repository.save(new Customer("Eric", "TheWesternKind"));
      repository.save(new Customer("Pameela", "DaPM"));
      repository.save(new Customer("Keith", "Keitherson"));
      repository.save(new Customer("James", "Ducks"));
      repository.save(new Customer("Mike", "Lowercase"));

      // fetch all customers
      log.info("Customers found with findAll():");
      log.info("-------------------------------");
      for (Customer customer : repository.findAll()) {
        log.info(customer.toString());
      }
      log.info("");

      // fetch an individual customer by ID
      Customer customer = repository.findById(1L);
      log.info("Customer found with findById(1L):");
      log.info("--------------------------------");
      log.info(customer.toString());
      log.info("");

      // fetch customers by last name
      log.info("Customer found with findByLastName('Ox'):");
      log.info("--------------------------------------------");
      repository.findByLastName("Ox").forEach(ox -> {
        log.info(ox.toString());
      });
      // for (Customer ox : repository.findByLastName("ox")) {
      //  log.info(ox.toString());
      // }
      log.info("");
    };
  }

}