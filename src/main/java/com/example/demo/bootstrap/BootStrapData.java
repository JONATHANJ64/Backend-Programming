package com.example.demo.bootstrap;

import com.example.demo.entities.Customer;
import com.example.demo.dao.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public BootStrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Clear the entire repository
        customerRepository.deleteAll();

        // Save sample customers
        Customer customer1 = new Customer("Jim", "Dough", "123 Main Street", "54321", "111-222-3333", 10L);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Jane", "Smith", "456 Oak Avenue", "54322", "111-222-4444", 15L);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Bob", "Johnson", "789 Pine Street", "54323", "111-222-5555", 20L);
        customerRepository.save(customer3);

        Customer customer4 = new Customer("Alice", "Williams", "101 Elm Road", "54324", "111-222-6666", 25L);
        customerRepository.save(customer4);

        Customer customer5 = new Customer("Charlie", "Brown", "202 Cedar Lane", "54325", "111-222-7777", 30L);
        customerRepository.save(customer5);
    }
}

